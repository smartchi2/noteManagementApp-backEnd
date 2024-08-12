package org.noteey.noteManager.dtos.responses;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class RegisterUserResponse {
    private String name;
    private String email;
    private String password;
    private String userId;
}
