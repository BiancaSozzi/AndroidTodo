package intermediate.course.tasks

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import intermediate.course.R
import intermediate.course.models.Task
import intermediate.course.models.Todo
import kotlinx.android.synthetic.main.fragment_tasks_list.*

class TasksListFragment : Fragment() {

    lateinit var touchActionDelegete: TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        context?.let {
            if ( it is TouchActionDelegate) {
                touchActionDelegete = it
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
        return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(mutableListOf(
            Task("testing 1", mutableListOf(
                Todo("Test one"),
                Todo("Test two", true)
                )
            ),
            Task("testing 2")
        ), touchActionDelegete)
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = TasksListFragment().apply{
            Bundle()
        }
    }

    interface TouchActionDelegate {
        fun onAddButtonClick(value: String)
    }
}
