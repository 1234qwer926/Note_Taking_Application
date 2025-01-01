package com.Pavan.NoteTaking.Service;

import com.Pavan.NoteTaking.Model.Note;
import com.Pavan.NoteTaking.Repo.NoteRepo;
import com.Pavan.NoteTaking.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepo repo;

    @Autowired
    private UserRepo userRepo;

    public List<Note> getAllNotes(String username) {
        return repo.findByUserUsername(username);
    }
    public String AddNote(Note note,String username) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        note.setDate((String) dtf.format(now));
        note.setUsername(username);  // Associate the note with the user
        repo.save(note);
        return "Note added successfully!";
    }
    public Note getOneNote(int id, String username) {
        return repo.findByIdAndUsername(id,username);
    }


    public String UpdateNotes(Note note, String username) {
        repo.save(note);
        return "Note updated successfully!";
    }

    public String DeleteNote(int id, String username) {
        repo.deleteByIdAndUsername(id,username);
        return "Note deleted successfully!";
    }
}
