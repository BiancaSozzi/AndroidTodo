package intermediate.course.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import intermediate.course.models.Note

class NoteViewModel : ViewModel(), NoteListViewContract {

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData
    private val model: NoteModel = NoteModel()

    init {
        _noteListLiveData.postValue(model.getFakeData())
    }
}