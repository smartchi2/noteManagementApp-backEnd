package org.noteey.noteManager.controller;

import org.noteey.noteManager.apiresponses.Api;
import org.noteey.noteManager.data.models.User;
import org.noteey.noteManager.dtos.requests.LoginRequest;
import org.noteey.noteManager.dtos.requests.RegisterUserRequest;
import org.noteey.noteManager.dtos.responses.LoginResponse;
import org.noteey.noteManager.dtos.responses.RegisterUserResponse;
import org.noteey.noteManager.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api/v1")
public class UserServiceImplController {
    @Autowired
    private UsersService userService;

    @RequestMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest request) {
        try{
            RegisterUserResponse newUser = userService.registerUser(request);
            return new ResponseEntity<>(new Api<>(true,registerUser(request)), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new Api<>(false,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


//    public User login(String username, String password) {
//        User existingUser = new User();
//        existingUser.setName(username);
//        existingUser.setPassword(password);
//        return existingUser;
//    }



}
