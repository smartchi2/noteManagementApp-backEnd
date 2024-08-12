package org.noteey.noteManager.controller;


import org.noteey.noteManager.data.models.Note;
import org.noteey.noteManager.dtos.requests.*;
import org.noteey.noteManager.dtos.responses.*;
import org.noteey.noteManager.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Api/v3")
public class NoteController {
    @Autowired
    NoteService noteService;

    @RequestMapping("/addNote")
    public ResponseEntity<?> addNote(@RequestBody AddNoteRequest request) {
        try{
            AddNoteResponse response = noteService.addNote(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @RequestMapping("/updateNote")
    public ResponseEntity<?> updateNote(@RequestBody UpdateNoteRequest request) {
        try{
            UpdateNoteResponse response = noteService.updateNote(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping("/deleteNote")
    public ResponseEntity<?> deleteNote(@RequestBody DeleteNoteRequest request) {
        try{
            DeleteNoteResponse response = noteService.deleteNote(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/findAllNotes")
    public ResponseEntity<?> allNote(@RequestBody FindAllNotesRequest request){
        try{
            FindAllNotesResponse response = noteService.allNotes(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }

    }

    @RequestMapping("deleteAllNotes")
    public ResponseEntity<?> deleteAll(){
        try{
            DeleteAllResponse response = noteService.deleteAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @RequestMapping("/viewNotes")
    public ResponseEntity<?> viewNote(@RequestBody ViewNoteRequest request){
        try{
            ViewNoteResponse response = noteService.viewNote(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping("findPostByTitle")
    public ResponseEntity<?> findNoteByTitle(@RequestBody FindNoteByTitleRequest request){
        try{
            Note response = noteService.findNoteByTitle(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/shareNotes")
    public ResponseEntity<?> shareNote(@RequestBody ShareNoteRequest request){
        try{
            Note response = noteService.shareNote(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping("/UnshareNote")
    public  ResponseEntity<?> unshareNote(@RequestBody UnShareNoteRequest request){
        try{
            Note response = noteService.unshareNote(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
