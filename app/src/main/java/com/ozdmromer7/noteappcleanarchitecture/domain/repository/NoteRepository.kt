package com.ozdmromer7.noteappcleanarchitecture.domain.repository


import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Notes>>
    suspend fun getNoteById(id: Int):Notes?
    suspend fun addNote(note: Notes)
    suspend fun deleteNote(note: Notes)

}