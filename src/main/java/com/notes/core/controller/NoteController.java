package com.notes.core.controller;

import com.notes.core.entity.Note;
import com.notes.core.model.NoteModel;
import com.notes.core.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class NoteController {

    @Autowired
    @Qualifier("noteService")
    NoteService service;

    @GetMapping("/notes")
    public List<NoteModel> getNotes() {
        return service.getNotes();
    }

    @GetMapping("/note/{id}")
    public Note getNote(@PathVariable("id") long id) {
        return service.getNote(id);
    }

    @PostMapping("/note")
    public boolean addNote(@RequestBody @Valid Note note) {
        return service.create(note);
    }

    @PutMapping("/note")
    public boolean updateNote(@RequestBody @Valid Note note) {
        return service.update(note);
    }

    @DeleteMapping("/note/{id}")
    public boolean deleteNote(@PathVariable("id") long id) {
        return service.delete(id);
    }
}
