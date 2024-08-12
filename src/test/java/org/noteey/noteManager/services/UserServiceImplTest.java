package org.noteey.noteManager.services;

import org.junit.jupiter.api.Test;
import org.noteey.noteManager.dtos.requests.LoginRequest;
import org.noteey.noteManager.dtos.requests.RegisterUserRequest;
import org.noteey.noteManager.dtos.responses.LoginResponse;
import org.noteey.noteManager.dtos.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UsersService userService;

    @Test
    public void testIf_NewUser_CanBeAdded() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setName("Smart Sunday");
        request.setPassword("1234");
        request.setEmail("smart.sunday@gmail.com");
        RegisterUserResponse response = userService.registerUser(request);
        assertNotNull(response);
        assertEquals("Smart Sunday",response.getName(),"Smart ");


    }

    @Test
    public void testIf_UserCanLogIn() {
        RegisterUserRequest userRequest = new RegisterUserRequest();
        userRequest.setName("Smart Sunday");
        userRequest.setPassword("1234");
        userRequest.setEmail("smart.sunday@gmail.com");
        RegisterUserResponse registerUser = userService.registerUser(userRequest);

        LoginRequest request = new LoginRequest();
        request.setPassword("1234");
        request.setEmail(registerUser.getEmail());

        LoginResponse response = userService.login(request);
        assertEquals("Smart Sunday",response.getName());
    }
    @Test
    public void testIf_WeCanFindUserById() {
        LoginRequest request = new LoginRequest();
        request.setPassword("1234");
        LoginResponse response = userService.login(request);
        assertNotNull(response);
        assertThat(response.getUserid()).isNotNull();

    }

    @Test
    public void testIf_UserExists() {
        LoginRequest request = new LoginRequest();
        request.setEmail("smart.sunday@gmail.com");
        LoginResponse response = userService.login(request);
        assertNotNull(response);
        assertThat(response.getUserid()).isNotNull();
    }

    @Test
    public void testIf_WeCanFindAllSingleUsersWithNotes() {
        LoginRequest request = new LoginRequest();
        request.setPassword("1234");
        LoginResponse response = userService.login(request);
        assertNotNull(response);
        assertThat(response.getUserid()).isNotNull();

    }

    @Test
    public void testIf_AllUsers_CanBeFind(){
        LoginRequest request = new LoginRequest();
        request.getPassword();
        request.getEmail();
        LoginResponse response = userService.login(request);
        assertNotNull(response);


    }
}