package com.notes.core.repository;

import com.notes.core.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("noteRepository")
public interface NoteRepository extends JpaRepository<Note, Serializable>, PagingAndSortingRepository<Note, Serializable> {
    Note findById(long id);
    Note findByName(String name);
    Note findByNameAndTitle(String name, String title);
    List<Note> findByTitle(String title);
    Page<Note> findAll(Pageable pageable);
}
