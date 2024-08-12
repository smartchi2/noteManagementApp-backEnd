package org.noteey.noteManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
public class FindUserById {
    @Id
    private String noteId;
    private String noteTitle;
}
