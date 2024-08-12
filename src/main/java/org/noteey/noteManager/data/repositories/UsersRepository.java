package org.noteManagementApplication.noteManager.data.repositories;

import org.noteManagementApplication.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
