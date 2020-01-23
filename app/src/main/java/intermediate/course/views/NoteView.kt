package intermediate.course.views

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import intermediate.course.models.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(note: Note) {
        noteDescription.text = note.description
    }
}