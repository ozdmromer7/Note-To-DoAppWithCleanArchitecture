package com.ozdmromer7.noteappcleanarchitecture.domain.use_case

import com.ozdmromer7.noteappcleanarchitecture.domain.model.InvalidNoteException
import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes
import com.ozdmromer7.noteappcleanarchitecture.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val noteRepository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(notes: Notes) {
        if (notes.title.isBlank()) {
            throw InvalidNoteException("The title can not be empty")
        }
        if (notes.content.isBlank()) {
            throw InvalidNoteException("The content can not be empty")
        }
        noteRepository.addNote(notes)
    }
}