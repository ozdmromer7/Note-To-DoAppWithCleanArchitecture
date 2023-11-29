package com.ozdmromer7.noteappcleanarchitecture.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes

@Database(
    entities = [Notes::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NotesDao

    companion object {

        const val DATABASE_NAME = "notes_database"
    }
}