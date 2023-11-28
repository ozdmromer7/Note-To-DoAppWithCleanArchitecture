package com.ozdmromer7.noteappcleanarchitecture.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey
    val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Color.Blue, Color.Red, Color.Green, Color.Magenta, Color.Yellow)
    }
}

class InvalidNoteException(message: String) : Exception(message = message)
