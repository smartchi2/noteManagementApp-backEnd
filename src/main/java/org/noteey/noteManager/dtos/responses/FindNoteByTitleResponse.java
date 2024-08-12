package org.noteey.noteManager.dtos.responses;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindNoteByTitleResponse {
    private String title;
    private String content;
}
