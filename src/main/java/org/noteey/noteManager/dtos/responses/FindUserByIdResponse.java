package org.noteey.noteManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class FindUserByIdResponse {
    private String noteId;
    private String title;
}
