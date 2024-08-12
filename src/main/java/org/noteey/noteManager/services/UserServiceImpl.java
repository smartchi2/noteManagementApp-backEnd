package org.noteey.noteManager.services;

import org.noteey.noteManager.data.models.Note;
import org.noteey.noteManager.data.models.SharedUser;
import org.noteey.noteManager.data.models.User;
import org.noteey.noteManager.data.repositories.UsersRepository;
import org.noteey.noteManager.dtos.requests.LoginRequest;
import org.noteey.noteManager.dtos.requests.RegisterUserRequest;
import org.noteey.noteManager.dtos.responses.LoginResponse;
import org.noteey.noteManager.dtos.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UsersService {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private NoteServiceImpl noteServiceImpl;


    @Override
    public LoginResponse login(LoginRequest request) {
        boolean isUserRegistered = userRepository.existsByEmail(request.getEmail());

        if (!isUserRegistered) {
            throw new RuntimeException("Not a registered user");
        }

        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        boolean isPasswordCorrect = user.getPassword().equals(request.getPassword());
        if (!isPasswordCorrect) {
            throw new RuntimeException("Incorrect password");
        }
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setIsLoggedIn(true);
        User savedUser = userRepository.save(user);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserid(savedUser.getUserId());
        loginResponse.setEmail(savedUser.getEmail());
        loginResponse.setName(savedUser.getName());

        return loginResponse;


    }


    @Override
    public User findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public boolean userExists(String userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        if (userExists(request.getEmail())) {
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
        return userRepository.findAll();
    }



    @Override
    public List<User> findSingleUserWithManyNotes() {
        for (User user : userRepository.findAll()) {
            if (user.getUserId().equals(user.getUserId())) {
                return userRepository.findAll();
            }

        }
        return null;


    }

    @Override
    public void unshareWith(String userId, String noteId) {
        Note note = noteServiceImpl.findById(noteId);
        Iterator<SharedUser> iterator = note.getSharedWith().iterator();
        while (iterator.hasNext()) {
            SharedUser sharedUser = iterator.next();
            if (sharedUser.getUserId().equals(userId)) {
                iterator.remove();
                break;
            }
        }

    }

}
