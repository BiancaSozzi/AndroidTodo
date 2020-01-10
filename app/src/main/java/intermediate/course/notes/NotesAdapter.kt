package intermediate.course.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.R
import intermediate.course.models.Note
import intermediate.course.tasks.TaskAdapter
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(
    private val noteList: MutableList<Note> = mutableListOf()
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_note,
                parent,
                false
            )
        )

    override fun getItemCount(): Int =  noteList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(noteList.get(position))
    }


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun onBind(note: Note){
            view.noteDescription.text = note.description
        }
    }
}