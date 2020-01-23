package intermediate.course.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.R
import intermediate.course.foundations.BaseRecyclerAdapter
import intermediate.course.models.Note
import intermediate.course.navigation.NavigationActivity.Companion.FRAGMENT_VALUE_NOTE
import intermediate.course.tasks.TaskAdapter
import intermediate.course.views.NoteView
import kotlinx.android.synthetic.main.item_note.view.*
import kotlinx.android.synthetic.main.view_add_button.view.*

class NotesAdapter(
    noteList: MutableList<Note> = mutableListOf(),
    val touchActionDelegate: NotesListFragment.TouchActionDelegate
): BaseRecyclerAdapter<Note>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if (viewType == TYPE_ADD_BUTTON){
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
    } else {
        NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
    }


    class NoteViewHolder(view: View): BaseViewHolder<Note>(view){
        override fun onBind(data: Note, listIndex: Int) {
            (view as NoteView).initView(data)
        }
    }

    inner class AddButtonViewHolder(view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view){
        override fun onBind(data: Unit, listIndex: Int) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)

            view.setOnClickListener{
                touchActionDelegate.onAddButtonClick(FRAGMENT_VALUE_NOTE)
            }
        }
    }
}