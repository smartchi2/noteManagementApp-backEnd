package org.noteManagementApplication.noteManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    private String name;
    private String password;
}
