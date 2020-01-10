package intermediate.course.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.R
import intermediate.course.foundations.BaseRecyclerAdapter
import intermediate.course.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf()
): BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))

    class ViewHolder(view: View):  BaseViewHolder<Task>(view){
        override fun onBind(data: Task) {
            view.textView.text = data.title
        }
    }
}