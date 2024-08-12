package org.noteey.noteManager.services;


import org.noteey.noteManager.data.models.User;
import org.noteey.noteManager.dtos.requests.LoginRequest;
import org.noteey.noteManager.dtos.responses.LoginResponse;
import org.noteey.noteManager.dtos.responses.RegisterUserResponse;
import org.noteey.noteManager.dtos.requests.RegisterUserRequest;

import java.util.List;


public interface UsersService {
    LoginResponse login(LoginRequest request);
    User findUserById(String userId);
    boolean userExists(String username);
    RegisterUserResponse registerUser(RegisterUserRequest request);
    List<User> findAllUsers();
    List<User> findSingleUserWithManyNotes();


    void unshareWith(String userId, String noteId);
}
