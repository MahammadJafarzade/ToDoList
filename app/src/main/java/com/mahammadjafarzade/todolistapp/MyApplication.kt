package com.mahammadjafarzade.todolistapp

import android.app.Application
import com.mahammadjafarzade.todolistapp.db.AppDataBase
import com.mahammadjafarzade.todolistapp.repository.NoteRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}