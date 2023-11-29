package com.ozdmromer7.noteappcleanarchitecture.domain.use_case

import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes
import com.ozdmromer7.noteappcleanarchitecture.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(notes: Notes) {

        noteRepository.deleteNote(notes)

    }
}