package intermediate.course.foundations

import intermediate.course.notes.INoteModel
import intermediate.course.notes.NoteLocalModel
import intermediate.course.tasks.ITaskModel
import intermediate.course.tasks.TaskLocalModel
import toothpick.Toothpick
import toothpick.config.Module

object ApplicationScope {
    val scope = Toothpick.openScope(this).apply {
        installModules(ApplicationModule)
    }
}

object ApplicationModule: Module() {
    init {
        bind(INoteModel::class.java).toInstance(NoteLocalModel())
        bind(ITaskModel::class.java).toInstance(TaskLocalModel())
    }
}