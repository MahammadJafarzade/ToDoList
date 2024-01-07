package com.mahammadjafarzade.todolistapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mahammadjafarzade.todolistapp.model.Note

class NoteListAdapter(val context: Context,
                      private var noteList : MutableList<Note>,
                      var onItemClick : (Note)->Unit) : BaseAdapter() {

    fun addNewNote(note: Note){
        noteList.add(note)
        notifyDataSetChanged()
    }
    override fun getCount(): Int {
        return  noteList.count()
    }

    override fun getItem(position: Int): Any {
        return noteList[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

}
