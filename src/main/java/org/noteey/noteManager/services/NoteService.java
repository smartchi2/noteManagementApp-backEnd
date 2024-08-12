package org.noteey.noteManager.services;

import org.noteey.noteManager.data.models.Note;
import org.noteey.noteManager.dtos.requests.*;
import org.noteey.noteManager.dtos.responses.*;



public interface NoteService {
    AddNoteResponse addNote(AddNoteRequest request);
    UpdateNoteResponse updateNote(UpdateNoteRequest request);
    DeleteNoteResponse deleteNote(DeleteNoteRequest note);
    Note findById(String request);
    FindAllNotesResponse allNotes(FindAllNotesRequest request);
    ViewNoteResponse viewNote(ViewNoteRequest request);
    Note findNoteByTitle(FindNoteByTitleRequest request);
    Note shareNote(ShareNoteRequest request);
    Note unshareNote(UnShareNoteRequest request);
    DeleteAllResponse  deleteAll();
}
