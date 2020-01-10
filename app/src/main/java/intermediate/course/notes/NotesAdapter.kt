package intermediate.course.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.R
import intermediate.course.foundations.BaseRecyclerAdapter
import intermediate.course.models.Note
import intermediate.course.tasks.TaskAdapter
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(
    noteList: MutableList<Note> = mutableListOf()
): BaseRecyclerAdapter<Note>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    class ViewHolder(view: View): BaseViewHolder<Note>(view){
        override fun onBind(data: Note) {
            view.noteDescription.text = data.description
        }
    }
}