package intermediate.course.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import intermediate.course.models.Note
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class NoteViewModel : ViewModel(), NoteListViewContract {

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    @Inject
    lateinit var model: INoteModel

    init {
        val scope = Toothpick.openScope(this)
        scope.installModules(object : Module() {
            init {
                bind(INoteModel::class.java).toInstance(NoteLocalModel())
            }
        })
        Toothpick.inject(this, scope)
        _noteListLiveData.postValue(model.getFakeData())
    }
}