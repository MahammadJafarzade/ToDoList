package com.mahammadjafarzade.todolistapp

import android.accounts.AuthenticatorDescription
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahammadjafarzade.todolistapp.db.AppDataBase
import com.mahammadjafarzade.todolistapp.model.Note
import com.mahammadjafarzade.todolistapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor (var noteRepository: NoteRepository) :ViewModel(){
    var noteTitle = MutableLiveData<String>()
    var noteDescription = MutableLiveData<String>()
    fun getAll() : LiveData<List<Note>> {
        return noteRepository.getAll()
    }
    fun insertNote(note : Note){
        viewModelScope.launch {
            noteRepository.insert(note)
        }
    }
}