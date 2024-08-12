package org.noteey.noteManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
public class UpdateNoteRequest {
    private String title;
    private String content;
}
