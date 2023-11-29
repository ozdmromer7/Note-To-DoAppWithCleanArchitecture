package com.ozdmromer7.noteappcleanarchitecture.di

import android.app.Application
import androidx.room.Room
import com.ozdmromer7.noteappcleanarchitecture.data.data_source.NoteDatabase
import com.ozdmromer7.noteappcleanarchitecture.data.repository.NoteRepositoryImpl
import com.ozdmromer7.noteappcleanarchitecture.domain.repository.NoteRepository
import com.ozdmromer7.noteappcleanarchitecture.domain.use_case.AddNoteUseCase
import com.ozdmromer7.noteappcleanarchitecture.domain.use_case.DeleteNoteUseCase
import com.ozdmromer7.noteappcleanarchitecture.domain.use_case.GetNoteByIdUseCase
import com.ozdmromer7.noteappcleanarchitecture.domain.use_case.GetNotesUseCase
import com.ozdmromer7.noteappcleanarchitecture.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(application: Application):NoteDatabase{

        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase):NoteRepository{
        return NoteRepositoryImpl(
            notesDao = noteDatabase.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository):NoteUseCases{
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(noteRepository),
            addNoteUseCase = AddNoteUseCase(noteRepository),
            getNoteByIdUseCase = GetNoteByIdUseCase(noteRepository)
        )
    }
}