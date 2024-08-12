package org.noteey.noteManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.noteey.noteManager.data.models.SharedUser;

import java.util.List;

@Setter
@Getter
public class ShareNoteRequest {
   private  String noteId;
   private String userId;
   private String permissions;
   private List<SharedUser> sharedWith;
}
