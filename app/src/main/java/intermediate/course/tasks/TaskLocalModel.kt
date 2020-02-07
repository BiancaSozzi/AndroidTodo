package intermediate.course.tasks

import android.util.Log
import intermediate.course.models.Task
import intermediate.course.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor() : ITaskModel {

    override fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "testing 1", mutableListOf(
                Todo("Test one"),
                Todo("Test two", true)
            )
        ),
        Task("testing 2"),
        Task(
            "Testing Three", mutableListOf(
                Todo("Test A"),
                Todo("Test B")
            )
        )
    )

    override fun addTask(task: Task, callback: SuccessCallback) {
        Log.d("Udemy Course", task.toString())
        callback.invoke(true)
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveTasks(): List<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}