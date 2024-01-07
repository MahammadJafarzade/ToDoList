package com.mahammadjafarzade.todolistapp.di

import com.mahammadjafarzade.todolistapp.repository.NoteRepoInterface
import com.mahammadjafarzade.todolistapp.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class NoteRepositoryModule {
    @Binds
    abstract fun bindRepository(prm : NoteRepository) : NoteRepoInterface
}