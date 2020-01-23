package intermediate.course.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import intermediate.course.models.Task
import intermediate.course.models.Todo

class TaskViewModel  : ViewModel(), TaskListViewContract {

    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    init {
        _taskListLiveData.postValue(getFakeData())
    }

    fun getFakeData() : MutableList<Task> = mutableListOf(
        Task("testing 1", mutableListOf(
            Todo("Test one"),
            Todo("Test two", true)
        )),
        Task("testing 2"),
        Task("Testing Three", mutableListOf(
            Todo("Test A"),
            Todo("Test B")
        ))
    )

    override fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isComplete;
    }
}