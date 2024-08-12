package org.noteey.noteManager.services;

import org.noteey.noteManager.Exceptions.NoteNotfoundException;
import org.noteey.noteManager.data.models.Note;
import org.noteey.noteManager.data.models.SharedUser;
import org.noteey.noteManager.data.repositories.NoteRepository;
import org.noteey.noteManager.data.repositories.UsersRepository;
import org.noteey.noteManager.dtos.responses.*;
import org.noteey.noteManager.dtos.requests.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public AddNoteResponse addNote(AddNoteRequest request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        Note savedNote = noteRepository.save(note);

        AddNoteResponse response = new AddNoteResponse();
        response.setNoteId(savedNote.getNoteId());
        response.setTitle(savedNote.getTitle());
        response.setContent(savedNote.getContent());
        return response;

    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest request) {
        Note note = new Note();
        note.setContent(request.getContent());
        note.setTitle(request.getTitle());
        Note savedNote = noteRepository.save(note);
        UpdateNoteResponse response = new UpdateNoteResponse();
        response.setContent(response.getContent());
        response.setTitle(request.getTitle());
        return response;
    }

    @Override
    public DeleteNoteResponse deleteNote(DeleteNoteRequest request) {
        Note note = noteRepository.findById(request.getNoteId()).orElseThrow();
        noteRepository.delete(note);
        DeleteNoteResponse response = new DeleteNoteResponse();
        response.setMessage("Note deleted");
        return response;
    }

    @Override
    public Note findById(String id) {
         return noteRepository.findById(id).orElseThrow(() -> new NoteNotfoundException("note id not found"));



    }

    @Override
    public FindAllNotesResponse allNotes(FindAllNotesRequest request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        Note savedNote = noteRepository.save(note);

        FindAllNotesResponse response = new FindAllNotesResponse();
        response.setTitle(response.getTitle());
        response.setContent(response.getContent());
        noteRepository.findById(savedNote.getNoteId().describeConstable().orElseThrow(() -> new NoteNotfoundException("note id not found")));
        String foundId = savedNote.getNoteId();
        response.setNoteId(foundId);
        return response;



    }

    @Override
    public ViewNoteResponse viewNote(ViewNoteRequest request) {
        List<Note> notes = noteRepository.findAll();
        if (notes.size() == 0) {
            throw new NoteNotfoundException("note not found");
        } else {
            return new ViewNoteResponse();
        }
    }

    @Override
    public Note findNoteByTitle(FindNoteByTitleRequest request) {
        Note check = noteRepository.findNoteByTitle(request.getTitle());
        if (check == null) {
            throw new NoteNotfoundException("note title not found");
        }
        return check;

    }

    @Override
    public Note shareNote(ShareNoteRequest request) {
        Note request2 = noteRepository.findById(request.getNoteId())
                .orElseThrow(() -> new NoteNotfoundException("note not found"));
        request2.getSharedWith().add(new SharedUser(request.getUserId(), request.getPermissions()));
        return noteRepository.save(request2);
    }

    @Override
    public Note unshareNote(UnShareNoteRequest request) {
        Note note = noteRepository.findById(request.getNoteId())
                .orElseThrow(() -> new RuntimeException("Note not found"));
       note.getSharedWith().remove(new SharedUser(request.getUserId(), request.getNoteId()));
        return noteRepository.save(note);
}


    @Override
    public DeleteAllResponse deleteAll() {
        noteRepository.deleteAll();

        DeleteAllResponse response = new DeleteAllResponse();
        response.setMessage("Notes deleted");
        return response;
    }
}
