package com.ozdmromer7.noteappcleanarchitecture.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNotes(): Flow<List<Notes>>
    @Query("SELECT * FROM Notes WHERE id= :id")
    suspend fun getNoteById(id: Int) : Notes?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Notes)
    @Delete
    suspend fun deleteNote(note: Notes)
}