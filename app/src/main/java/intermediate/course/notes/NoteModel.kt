package intermediate.course.notes

import intermediate.course.models.Note

class NoteModel {

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("My first note"),
        Note("My second note"),
        Note("this is another note")
    )
}