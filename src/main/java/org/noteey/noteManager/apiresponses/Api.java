package org.noteManagementApplication.apiresponses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Api <T>{
 private boolean successful;
 private T message;
}
