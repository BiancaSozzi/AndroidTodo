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
import kotlinx.android.synthetic.main.fragment_tasks_list.*

class TasksListFragment : Fragment() {

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
            Task("testing 1"),
            Task("testing 2")
        ))
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = TasksListFragment().apply{
            Bundle()
        }
    }
}
