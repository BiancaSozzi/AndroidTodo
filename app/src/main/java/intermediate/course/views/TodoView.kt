package intermediate.course.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.CheckBox
import android.widget.TextView

import androidx.constraintlayout.widget.ConstraintLayout

import intermediate.course.R
import intermediate.course.models.Todo

class TodoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var checkBox: CheckBox? = null
    private var descriptionView: TextView? = null

    fun initView(todo: Todo) {
        checkBox = findViewById(R.id.checkbox)
        descriptionView = findViewById(R.id.descriptionView)

        descriptionView!!.text = todo.description
        checkBox!!.isChecked = todo.isComplete

        if (todo.isComplete) {
            createStrikeThrough()
        }

        setUpCheckStateListener()
    }

    fun setUpCheckStateListener() {
        checkBox!!.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                createStrikeThrough()
            } else {
                removeStrikethrough()
            }
        }
    }

    private fun createStrikeThrough() {
        descriptionView!!.paintFlags = descriptionView!!.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

    }

    private fun removeStrikethrough() {
        descriptionView!!.paintFlags =
            descriptionView!!.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}
