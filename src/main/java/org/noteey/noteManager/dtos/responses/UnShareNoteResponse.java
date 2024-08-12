package org.noteey.noteManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.noteey.noteManager.data.models.Note;

@Setter
@Getter
public class UnShareNoteResponse {
    private Note note;
    private String message;
}
