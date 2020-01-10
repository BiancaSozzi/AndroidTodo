package intermediate.course.foundations

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T> (
    private val list: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder<T>).onBind(list[position])
    }

    abstract class BaseViewHolder<E>(val view: View): RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: E)
    }
}