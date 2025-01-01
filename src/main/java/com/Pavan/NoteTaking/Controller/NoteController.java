package com.Pavan.NoteTaking.Controller;

import com.Pavan.NoteTaking.Model.Note;
import com.Pavan.NoteTaking.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class NoteController {
    @Autowired
    private NoteService service;
    @GetMapping("/notes")
    public List<Note> allNotes(Authentication authentication) {
        String username = authentication.getName();
        System.out.println(username);
        return service.getAllNotes(username);
    }
    @PostMapping("/notes/add")
    public String Add(@RequestBody Note note,Authentication authentication) {
        String username= authentication.getName();
        return service.AddNote(note,username);
    }
    @GetMapping("/notes/{id}")
    public Note OneNote(@PathVariable int id,Authentication authentication){
        String username= authentication.getName();
        return service.getOneNote(id,username);
    }
    @PutMapping("/notes/{id}")
    public String UpdateNote(@PathVariable int id, @RequestBody Note updateNote,Authentication authentication){
        String username= authentication.getName();
        return service.UpdateNotes(updateNote,username);
    }
    @DeleteMapping("/notes/{id}")
    public String Delete(@PathVariable int id,Authentication authentication){
        String username= authentication.getName();
        return service.DeleteNote(id,username);
    }
}
