package intermediate.course.notes

import intermediate.course.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor() : INoteModel {

    override fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("My first note"),
        Note("My second note"),
        Note("this is another note")
    )

    override fun addNote(note: Note, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveNotes(): List<Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}