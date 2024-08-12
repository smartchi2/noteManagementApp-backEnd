package org.noteey.noteManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.noteey.noteManager.data.models.Note;

@Getter
@Setter
public class ViewNoteResponse {
    private String noteId;
    private String title;
    private String content;

}
