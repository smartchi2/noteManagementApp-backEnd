package org.noteManagementApplication.noteManager.services;

import org.noteManagementApplication.noteManager.data.models.Notes;
import org.noteManagementApplication.noteManager.dtos.responses.AddNoteResponse;
import org.noteManagementApplication.noteManager.dtos.responses.UpdateNoteResponse;
import org.noteManagementApplication.noteManager.dtos.responses.DeleteNoteResponse;
import org.noteManagementApplication.noteManager.dtos.requests.AddNoteRequest;
import org.noteManagementApplication.noteManager.dtos.requests.UpdateNoteRequest;
import org.noteManagementApplication.noteManager.dtos.requests.DeleteNoteRequest;

import java.util.List;

public interface NoteService {
    AddNoteResponse addNote(AddNoteRequest note);
    UpdateNoteResponse updateNote(UpdateNoteRequest note);
    DeleteNoteResponse deleteNote(DeleteNoteRequest note);
    Notes getNoteById(int id);
    List<Notes> getAllNotes();

}
