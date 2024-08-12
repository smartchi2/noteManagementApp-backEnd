package org.noteey.noteManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.noteey.noteManager.data.models.SharedUser;

import java.util.List;

@Setter
@Getter
public class ShareNoteResponse {
    private String noteId;
    private String title;
    private String content;
    private List<SharedUser> sharedWith;
}
