package intermediate.course.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import intermediate.course.models.Task
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class TaskViewModel : ViewModel(), TaskListViewContract {

    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData
    @Inject
    lateinit var model: ITaskModel


    init {
        //open scope
        val scope = Toothpick.openScope(this)
        scope.installModules(Module().apply {
            bind(ITaskModel::class.java).toInstance(TaskLocalModel())
        })
        // Link taskViewModel to the scope
        Toothpick.inject(this, scope)
        _taskListLiveData.postValue(model.getFakeData())
    }

    override fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isComplete;
    }
}