package com.ozdmromer7.noteappcleanarchitecture.presentation.notes

import android.app.Application
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes
import com.ozdmromer7.noteappcleanarchitecture.domain.use_case.NoteUseCases
import com.ozdmromer7.noteappcleanarchitecture.domain.util.NoteOrder
import com.ozdmromer7.noteappcleanarchitecture.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    private val application: Application
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var deletedNote: Notes? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(events: NotesEvents) {

        when (events) {
            is NotesEvents.Order -> {

                if (state.value.noteOrder::class == events.noteOrder::class &&
                    state.value.noteOrder.orderType == events.noteOrder.orderType
                ) {
                    return
                }
                getNotes(events.noteOrder)

            }

            is NotesEvents.DeleteNote -> {

                viewModelScope.launch {
                    noteUseCases.deleteNoteUseCase(events.note)
                    deletedNote = events.note
                }

            }

            is NotesEvents.RestoreNote -> {

                viewModelScope.launch {

                    noteUseCases.addNoteUseCase(deletedNote ?: return@launch, context = application)
                    deletedNote = null
                }

            }

            is NotesEvents.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotesUseCase(noteOrder)
            .onEach {
                _state.value = state.value.copy(
                    notes = it, noteOrder = noteOrder
                )
            }.launchIn(viewModelScope)
    }
}