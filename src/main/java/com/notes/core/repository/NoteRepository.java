package com.notes.core.repository;

import com.notes.core.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("noteRepository")
public interface NoteRepository extends JpaRepository<Note, Serializable> {
    Note findByName(String name);
    List<Note> findByTitle(String title);
    Note findByNameAndTitle(String name, String title);
    Note findById(long id);
    Note findByIdAndName(long id, String name);
}
