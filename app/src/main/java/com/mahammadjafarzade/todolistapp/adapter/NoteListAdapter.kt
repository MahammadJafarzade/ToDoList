package com.mahammadjafarzade.todolistapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahammadjafarzade.todolistapp.R
import com.mahammadjafarzade.todolistapp.databinding.FragmentNoteBinding
import com.mahammadjafarzade.todolistapp.model.Note

class NoteListAdapter(val context: Context,
                      private var noteList : MutableList<Note>,
                      var onItemClick : (Note)->Unit) : BaseAdapter() {

    fun addNewNote(note: Note) {
        noteList.add(note)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return noteList.count()
    }

    override fun getItem(position: Int): Any {
        return noteList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, contentView: View?, p2: ViewGroup?): View {
        var newContentView = contentView
        var holder: ViewHolder
        if (contentView == null) {

            val binding: FragmentNoteBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.fragment_list,
                p2,
                false
            )
            holder = ViewHolder(binding, onItemClick)
            var newcontentView = binding.root
            return binding.root
        } else {
            holder = contentView.tag as ViewHolder
            holder.bind(noteList[position])
        }
        return newContentView!!
    }

    private class ViewHolder(var binding: FragmentNoteBinding, var onItemClick: (Note) -> Unit) {
        fun bind(note: Note) {
            //binding.txtTitle.text = note.title
            //binding.txtDescription.text = note.description
            binding.root.setOnClickListener {
                onItemClick(binding.btnInsert as Note)
            }
        }
    }
}

