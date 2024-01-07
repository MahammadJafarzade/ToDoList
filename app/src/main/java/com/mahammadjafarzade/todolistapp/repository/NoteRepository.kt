package com.mahammadjafarzade.todolistapp.repository

import androidx.lifecycle.LiveData
import com.mahammadjafarzade.todolistapp.dao.NoteDao
import com.mahammadjafarzade.todolistapp.model.Note
import javax.inject.Inject

interface NoteRepoInterface{

}

class NoteRepository @Inject constructor(private val noteDao: NoteDao) : NoteRepoInterface {
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }
    fun getAll() : LiveData<List<Note>>{
        return noteDao.getAll()
    }
}