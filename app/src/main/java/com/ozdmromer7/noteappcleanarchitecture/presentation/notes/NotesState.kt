package com.ozdmromer7.noteappcleanarchitecture.presentation.notes

import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes
import com.ozdmromer7.noteappcleanarchitecture.domain.util.NoteOrder
import com.ozdmromer7.noteappcleanarchitecture.domain.util.OrderType

data class NotesState(
    val notes: List<Notes> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
