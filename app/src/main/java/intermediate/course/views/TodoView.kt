package intermediate.course.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet

import androidx.constraintlayout.widget.ConstraintLayout

import intermediate.course.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {


    fun initView(todo: Todo, callback: ((Boolean) -> Unit)? = null) {
        checkbox.isChecked = todo.isComplete
        descriptionView.text = todo.description

        if (todo.isComplete) {
            descriptionView.setStrikeThrough()
        }

        setUpCheckStateListener(todo, callback)
    }

    fun setUpCheckStateListener(todo: Todo, callback: ((Boolean) -> Unit)? = null) {
        checkbox.setOnCheckedChangeListener { _, isChecked ->
            todo.isComplete = isChecked
            callback?.invoke(isChecked)
            if (isChecked) {
                descriptionView.setStrikeThrough()
            } else {
                descriptionView.removeStrikeThrough()
            }
        }
    }
}
