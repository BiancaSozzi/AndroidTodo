package intermediate.course.notes

import intermediate.course.models.Note

typealias SuccessCallback = (Boolean) -> Unit

interface INoteModel {

    // CRUD operations --> Create/ Retrieve / Update/ Delete

    fun addNote(note: Note, callback: SuccessCallback)
    fun updateNote(note: Note, callback: SuccessCallback)
    fun deleteNote(note: Note, callback: SuccessCallback)
    fun retrieveNotes() : List<Note>

    fun getFakeData(): MutableList<Note>

}