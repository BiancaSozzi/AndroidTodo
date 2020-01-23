package intermediate.course.notes


import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import intermediate.course.R

class NotesListFragment : Fragment() {

    lateinit var noteViewModel: NoteViewModel
    lateinit var contentView: NoteListView
    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let{
            if (it is TouchActionDelegate){
                touchActionDelegate = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false).apply {
            contentView = this as NoteListView
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setContentView()
    }

    private fun setContentView(){
        contentView.initView(touchActionDelegate, noteViewModel)
    }

    companion object {

        fun newInstance() = NotesListFragment().apply{
            Bundle()
        }
    }

    interface TouchActionDelegate {
        fun onAddButtonClick(value: String)
    }

    private fun bindViewModel() {
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        noteViewModel.noteListLiveData.observe(this, Observer{notesList ->
            contentView.updateList(notesList)
        })
    }

}
