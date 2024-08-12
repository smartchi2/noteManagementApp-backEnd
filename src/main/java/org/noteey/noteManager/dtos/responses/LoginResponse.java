package org.noteey.noteManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Setter
@Getter
public class LoginResponse {

    private String email;
    private String userid;
    private String name;


}
