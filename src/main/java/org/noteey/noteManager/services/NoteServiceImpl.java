package org.noteManagementApplication.noteManager.services;

import org.noteManagementApplication.noteManager.data.models.Notes;
import org.noteManagementApplication.noteManager.dtos.responses.AddNoteResponse;
import org.noteManagementApplication.noteManager.dtos.responses.DeleteNoteResponse;
import org.noteManagementApplication.noteManager.dtos.responses.UpdateNoteResponse;
import org.noteManagementApplication.noteManager.dtos.requests.AddNoteRequest;
import org.noteManagementApplication.noteManager.dtos.requests.DeleteNoteRequest;
import org.noteManagementApplication.noteManager.dtos.requests.UpdateNoteRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceImpl implements NoteService {
    @Override
    public AddNoteResponse addNote(AddNoteRequest note) {
        return null;
    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest note) {
        return null;
    }

    @Override
    public DeleteNoteResponse deleteNote(DeleteNoteRequest note) {
        return null;
    }

    @Override
    public Notes getNoteById(int id) {
        return null;
    }

    @Override
    public List<Notes> getAllNotes() {
        return List.of();
    }
}
