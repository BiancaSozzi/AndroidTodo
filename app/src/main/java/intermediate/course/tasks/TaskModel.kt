package intermediate.course.tasks

import intermediate.course.models.Task
import intermediate.course.models.Todo

class TaskModel {

    fun getFakeData(): MutableList<Task> = mutableListOf(
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
}