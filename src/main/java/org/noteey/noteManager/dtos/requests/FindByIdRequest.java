package org.noteey.noteManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindByIdRequest {
    public String noteId;
    public String title;

}
