package com.mahammadjafarzade.todolistapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mahammadjafarzade.todolistapp.adapter.NoteListAdapter
import com.mahammadjafarzade.todolistapp.databinding.FragmentListBinding
import com.mahammadjafarzade.todolistapp.db.AppDataBase
import com.mahammadjafarzade.todolistapp.model.Note
import com.mahammadjafarzade.todolistapp.repository.NoteRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()
    lateinit var binding : FragmentListBinding
    private lateinit var noteListAdapter: NoteListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun openNotePage(){
        val action = ListFragmentDirections.actionListFragmentToNoteFragment()
        findNavController().navigate(action)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container,false)

        binding.listBtn.setOnClickListener(){
            openNotePage()
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}