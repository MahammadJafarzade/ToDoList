package com.mahammadjafarzade.todolistapp.di

import android.content.Context
import androidx.room.Room
import com.mahammadjafarzade.todolistapp.dao.NoteDao
import com.mahammadjafarzade.todolistapp.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideNoteDao(appDataBase : AppDataBase) : NoteDao{
        return appDataBase.noteDao()
    }
    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context : Context) : AppDataBase{
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "noteDb").build()
    }
}