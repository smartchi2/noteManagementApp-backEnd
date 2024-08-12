package org.noteey.noteManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UnShareNoteRequest {
    private String noteId;
    private String userId;
}
