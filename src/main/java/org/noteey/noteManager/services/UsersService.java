package org.noteManagementApplication.noteManager.services;

import org.noteManagementApplication.data.models.User;
import org.noteManagementApplication.noteManager.dtos.requests.RegisterUserRequest;
import org.noteManagementApplication.noteManager.dtos.responses.RegisterUserResponse;

import java.util.List;


public interface UsersService {
    RegisterUserResponse login(RegisterUserRequest request);
    User findUserById(String id);
    boolean userExists(String username);
    RegisterUserResponse addNewUser(RegisterUserRequest request);
    List<User> findAllUsers();


}
