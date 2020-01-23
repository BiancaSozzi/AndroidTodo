package intermediate.course.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import intermediate.course.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NoteListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: NotesAdapter
    private lateinit var touchActionDelegate: NotesListFragment.TouchActionDelegate
    private lateinit var noteDelegate: NoteListViewContract

    fun initView(
        taDelegate: NotesListFragment.TouchActionDelegate,
        noDelegate: NoteListViewContract
    ) {
        setUpDelegates(taDelegate, noDelegate)
        setUpView()
    }

    private fun setUpDelegates(
        taDelegate: NotesListFragment.TouchActionDelegate,
        noDelegate: NoteListViewContract
    ) {
        touchActionDelegate = taDelegate
        noteDelegate = noDelegate
    }

    private fun setUpView() {

        notesListRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NotesAdapter(touchActionDelegate = touchActionDelegate)
        notesListRecyclerView.adapter = adapter

    }

    fun updateList(list: MutableList<Note>) {
        adapter.updateList(list)
    }
}