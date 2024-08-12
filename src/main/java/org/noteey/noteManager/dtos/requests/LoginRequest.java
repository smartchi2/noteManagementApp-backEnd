package org.noteey.noteManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
public class LoginRequest {
//    private String userId;
    private String email;
//    private String name;
    private String password;
}
