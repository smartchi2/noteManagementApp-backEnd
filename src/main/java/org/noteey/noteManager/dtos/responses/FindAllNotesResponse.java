package org.noteey.noteManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindAllNotesResponse {
    private String noteId;
    private String content;
    private String title;
}
