package com.ozdmromer7.noteappcleanarchitecture.data.repository

import com.ozdmromer7.noteappcleanarchitecture.data.data_source.NotesDao
import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes
import com.ozdmromer7.noteappcleanarchitecture.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val notesDao: NotesDao) : NoteRepository {
    override fun getNotes(): Flow<List<Notes>> {
        return notesDao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Notes? {
        return notesDao.getNoteById(id)
    }

    override suspend fun addNote(note: Notes) {
        notesDao.addNote(note)
    }

    override suspend fun deleteNote(note: Notes) {
        notesDao.deleteNote(note)
    }
}