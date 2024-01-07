package com.mahammadjafarzade.todolistapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mahammadjafarzade.todolistapp.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note : Note)

    @Query("SELECT * FROM note")
    fun getAll() : LiveData<List<Note>>

    @Delete
    suspend fun delete(note : Note)
}