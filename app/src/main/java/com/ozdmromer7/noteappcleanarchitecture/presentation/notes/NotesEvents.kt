package com.ozdmromer7.noteappcleanarchitecture.presentation.notes

import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes
import com.ozdmromer7.noteappcleanarchitecture.domain.repository.NoteRepository
import com.ozdmromer7.noteappcleanarchitecture.domain.util.NoteOrder

sealed class NotesEvents {
    data class Order(val noteOrder: NoteOrder) : NotesEvents()
    data class DeleteNote(val note: Notes) : NotesEvents()
    data object RestoreNote : NotesEvents()
    data object ToggleOrderSection : NotesEvents()
}
