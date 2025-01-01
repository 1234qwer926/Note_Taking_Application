package com.Pavan.NoteTaking.Repo;

import com.Pavan.NoteTaking.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Integer> {
    List<Note> findByUserUsername(String username);

    @Query(value = "delete  from note n where n.username=:username and n.id=:id",nativeQuery = true)
    void deleteByIdAndUsername(int id, String username);

    @Query(value = "Select * from note n where n.username=:username and n.id=:id",nativeQuery = true)
    Note findByIdAndUsername(int id, String username);
}
