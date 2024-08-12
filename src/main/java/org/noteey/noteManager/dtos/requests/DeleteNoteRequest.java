package org.noteey.noteManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
public class DeleteNoteRequest {
    private String title;
    private String noteId;

}
