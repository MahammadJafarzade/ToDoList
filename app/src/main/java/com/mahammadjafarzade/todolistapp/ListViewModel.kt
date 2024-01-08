package com.mahammadjafarzade.todolistapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mahammadjafarzade.todolistapp.model.Note
import com.mahammadjafarzade.todolistapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(val noteRepository: NoteRepository) : ViewModel() {


    fun getAllData() : LiveData<List<Note>>{
        return noteRepository.getAll()
    }

    fun insertNote(note: Note){
        viewModelScope.launch {
            noteRepository.insert(note)
        }
    }
}

