package intermediate.course.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import intermediate.course.models.Note

class NoteViewModel : ViewModel(), NoteListViewContract {

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    init {
        _noteListLiveData.postValue(getFakeData())
    }

    fun getFakeData() : MutableList<Note> = mutableListOf(
        Note("My first note"),
        Note("My second note"),
        Note("this is another note")
    )
}