package org.noteey.noteManager.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    private String noteId;
    private String title;
    private String content;
    private String viewNote;
    private String  userId;
    private String permission;
    private List<SharedUser> sharedWith;
    private LocalDateTime noteCreation = LocalDateTime.now();


}
