package org.noteey.noteManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class FindByIdRquest {
    @Id
    public String noteId;
    public String title;

}
