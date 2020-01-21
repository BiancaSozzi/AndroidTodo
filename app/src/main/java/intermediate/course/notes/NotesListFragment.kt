package intermediate.course.notes


import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import intermediate.course.R
import intermediate.course.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {

    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        context?.let{
            if (it is TouchActionDelegate){
                touchActionDelegate = it
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesListRecyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = NotesAdapter(mutableListOf(
            Note("My first note"),
            Note("My second note"),
            Note("this is another note")
        ), touchActionDelegate)
        notesListRecyclerView.adapter = adapter
    }

    companion object {

        fun newInstance() = NotesListFragment().apply{
            Bundle()
        }
    }

    interface TouchActionDelegate {
        fun onAddButtonClick(value: String)
    }

}
