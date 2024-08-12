package org.noteManagementApplication.noteManager.services;

import org.noteManagementApplication.data.models.User;
import org.noteManagementApplication.noteManager.data.repositories.UsersRepository;
import org.noteManagementApplication.noteManager.dtos.requests.RegisterUserRequest;
import org.noteManagementApplication.noteManager.dtos.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService{
     @Autowired
     private UsersRepository userRepository;

    @Override
    public RegisterUserResponse login(RegisterUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        User savedUser = userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setUserId(savedUser.getUserId());
        response.setName(savedUser.getName());
        return response;
    }


    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
    }

    @Override
    public boolean userExists(String email) {
      return userRepository.existsById(email);
    }

    @Override
    public RegisterUserResponse addNewUser(RegisterUserRequest request) {
        if(userExists(request.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setPassword(request.getPassword());
        newUser.setEmail(request.getEmail());
        User registeredUser = userRepository.save(newUser);

        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUserId(registeredUser.getUserId());
        registerUserResponse.setName(registeredUser.getName());
        registerUserResponse.setPassword(registeredUser.getPassword());
        registerUserResponse.setEmail(registeredUser.getEmail());
        return registerUserResponse;
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }
}
