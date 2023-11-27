package com.ozdmromer7.noteappcleanarchitecture.data.data_source

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao():NotesDao
}