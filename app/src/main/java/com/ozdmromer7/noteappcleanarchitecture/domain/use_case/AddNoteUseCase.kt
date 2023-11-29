package com.ozdmromer7.noteappcleanarchitecture.domain.use_case

import android.content.Context
import com.ozdmromer7.noteappcleanarchitecture.domain.model.InvalidNoteException
import com.ozdmromer7.noteappcleanarchitecture.domain.model.Notes
import com.ozdmromer7.noteappcleanarchitecture.domain.repository.NoteRepository
import kotlin.jvm.Throws
import com.ozdmromer7.noteappcleanarchitecture.R
import java.lang.reflect.Constructor
import javax.inject.Inject


class AddNoteUseCase(
    private val noteRepository: NoteRepository
)
{
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(notes: Notes, context: Context) {
        if (notes.title.isBlank()) {
            throw InvalidNoteException(
                context.getString(
                    R.string.can_not_be_empty,
                    context.getString(R.string.title)
                )
            )
        }
        if (notes.content.isBlank()) {
            throw InvalidNoteException(
                context.getString(
                    R.string.can_not_be_empty,
                    context.getString(R.string.content)
                )
            )
        }
        noteRepository.addNote(notes)
    }
}