package org.noteManagementApplication.noteManager.dtos.responses;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserResponse {
    private String name;
    private String email;
    private String password;
    private String userId;
}
