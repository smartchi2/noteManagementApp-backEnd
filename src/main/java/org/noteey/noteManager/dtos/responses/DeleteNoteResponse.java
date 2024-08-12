package org.noteey.noteManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
public class DeleteNoteResponse {
    private String title;
    private String message;
}
