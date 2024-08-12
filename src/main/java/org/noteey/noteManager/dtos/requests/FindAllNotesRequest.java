package org.noteey.noteManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindAllNotesRequest {
    private String title;
    private String content;
    private String noteId;
}
