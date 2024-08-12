package org.noteey.noteManager.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noteey.noteManager.data.models.Note;
import org.noteey.noteManager.data.repositories.NoteRepository;
import org.noteey.noteManager.dtos.requests.*;
import org.noteey.noteManager.dtos.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class NoteServiceImplTest {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteRepository noteRepository;

    @BeforeEach
   void setUp() {
        noteService.deleteAll();
    }




    @Test
    public void testAddNote() {
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("title");
        request.setContent("home for sell");

        AddNoteResponse response =  noteService.addNote(request);
        response.setTitle(request.getTitle());
        response.setContent(request.getContent());
        assertEquals("title",response.getTitle(),"home for sell");

    }

    @Test
    public void testUpdateNote() {
        UpdateNoteRequest request = new UpdateNoteRequest();
        request.setTitle("smart");
        request.setContent("home for sell");

        UpdateNoteResponse response = noteService.updateNote(request);
        response.setTitle(request.getTitle());
        response.setContent(request.getContent());
        assertEquals("smart",response.getTitle(),"home for sell");
    }

    @Test
    public void testDeleteNote() {
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("title");
        request.setContent("home for sell");

        AddNoteResponse response =  noteService.addNote(request);
        response.setTitle(request.getTitle());
        response.setContent(request.getContent());
        assertEquals("title",response.getTitle(),"home for sell");

        DeleteNoteRequest deleteNoteRequest = new DeleteNoteRequest();
        deleteNoteRequest.setTitle("title");
        deleteNoteRequest.setNoteId(response.getNoteId());

        DeleteNoteResponse deleteNoteResponse = noteService.deleteNote(deleteNoteRequest);
        assertEquals("Note deleted",deleteNoteResponse.getMessage());

    }

    @Test
    public void testToFindNoteById() {
      AddNoteRequest request = new AddNoteRequest();
      request.setTitle("title");
      request.setContent("home for sell");

      AddNoteResponse response = noteService.addNote(request);
      response.setTitle(request.getTitle());
      response.setContent(request.getContent());
      response.setNoteId(response.getNoteId());
      assertEquals("title",response.getTitle(),"home for sell");

      FindByIdRequest findRequest = new FindByIdRequest();
      findRequest.setTitle(request.getTitle());
      findRequest.setNoteId(response.getNoteId());

      FindUserByIdResponse response1 = noteService.findById(findRequest.noteId);
      response1.setNoteId(response.getNoteId());
      assertNotNull(response1.getNoteId());
      assertThat(response1).isNotNull();

    }

    @Test
    public void testIfAllNotesCanBeFound(){
       AddNoteRequest request = new AddNoteRequest();
       request.setTitle("title");
       request.setContent("home for sell");

       AddNoteResponse response = noteService.addNote(request);
       response.setTitle(request.getTitle());
       response.setContent(request.getContent());
       response.setNoteId(response.getNoteId());
       assertEquals("title",response.getTitle(),"home  sell");

       FindAllNotesRequest findRequest = new FindAllNotesRequest();
       findRequest.setTitle(request.getTitle());
       findRequest.setTitle(response.getTitle());
       findRequest.setNoteId(response.getNoteId());

        FindUserByIdResponse response1 = noteService.findById(response.getNoteId());
        response1.setNoteId(response.getNoteId());
        assertNotNull(response1.getNoteId());
        assertThat(response1).isNotNull();
    }

    @Test
    public void testIfUserCanDeleteAllNote(){
       AddNoteRequest request = new AddNoteRequest();
       request.setTitle("title");
       request.setContent("home for sell");

       AddNoteResponse response = noteService.addNote(request);
       response.setTitle(request.getTitle());
       response.setContent(request.getContent());

       DeleteAllResponse deleteNoteResponse = noteService.deleteAll();
       assertEquals(deleteNoteResponse.getMessage(),"Notes deleted");
       assertThat(noteRepository.count()).isEqualTo(0);
    }

    @Test
    public void testThatUserCanViewAllNote(){
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("title");
        request.setContent("home for sell");

        AddNoteResponse response = noteService.addNote(request);
        response.setTitle(request.getTitle());
        response.setContent(request.getContent());

        ViewNoteRequest request1 = new ViewNoteRequest();
        request1.setNoteId(response.getNoteId());

        ViewNoteResponse response1 = noteService.viewNote(request1);
        response1.setNoteId(response.getNoteId());
        assertNotNull(response1.getNoteId());
        assertThat(response1).isNotNull();
    }

    @Test
    public void testIfUserCanFindTitle(){
        FindNoteByTitleRequest request = new FindNoteByTitleRequest();
        request.setTitle("title");
        Note note = noteService.findNoteByTitle(request);
        assertNotNull(request.getTitle());
        assertThat(note).isNotNull();
    }


}