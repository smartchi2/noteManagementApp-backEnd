package org.noteey.noteManager.data.repositories;

import org.noteey.noteManager.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    boolean existsByEmail(String email);

}
