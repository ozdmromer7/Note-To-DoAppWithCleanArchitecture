package com.ozdmromer7.noteappcleanarchitecture.domain.use_case

import com.ozdmromer7.noteappcleanarchitecture.domain.repository.NoteRepository

class GetNoteByIdUseCase(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(id: Int) {

        noteRepository.getNoteById(id)

    }
}