package org.noteey.noteManager.dtos.requests;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
}
