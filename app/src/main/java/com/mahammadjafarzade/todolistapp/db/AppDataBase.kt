package com.mahammadjafarzade.todolistapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mahammadjafarzade.todolistapp.dao.NoteDao
import com.mahammadjafarzade.todolistapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
}