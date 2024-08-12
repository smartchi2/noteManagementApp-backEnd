package org.noteey.noteManager.data.repositories;

import org.noteey.noteManager.data.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    Note findNoteByTitle(String title);

}
