package intermediate.course.notes

import intermediate.course.models.Note
import javax.inject.Inject

class NoteModel @Inject constructor() {

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("My first note"),
        Note("My second note"),
        Note("this is another note")
    )
}