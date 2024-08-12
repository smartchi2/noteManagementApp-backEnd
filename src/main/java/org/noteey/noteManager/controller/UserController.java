package org.noteey.noteManager.controller;

import org.noteey.noteManager.apiresponses.Api;
import org.noteey.noteManager.dtos.requests.LoginRequest;
import org.noteey.noteManager.dtos.responses.LoginResponse;
import org.noteey.noteManager.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Api/v2")
public class LoginServiceImplController {
    @Autowired
    private UsersService userService;
    @RequestMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try{
            LoginResponse login = userService.login(request);
            return new ResponseEntity<>(new Api<>(true,login), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Api<>(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
