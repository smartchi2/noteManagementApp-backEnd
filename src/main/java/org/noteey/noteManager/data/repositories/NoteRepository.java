package org.noteManagementApplication.noteManager.data.repositories;

import org.noteManagementApplication.noteManager.data.models.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Notes, String> {
    Notes findbyid(String id);

}
