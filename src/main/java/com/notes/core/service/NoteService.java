package com.notes.core.service;

import com.notes.core.converter.Converter;
import com.notes.core.entity.Note;
import com.notes.core.model.NoteModel;
import com.notes.core.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service("noteService")
public class NoteService {
    private final NoteRepository noteRepository;

    private final Converter converter;

    @Autowired
    public NoteService(@Qualifier("noteRepository") NoteRepository noteRepository, @Qualifier("converter") Converter converter) {
        this.noteRepository = noteRepository;
        this.converter = converter;
    }

    public boolean create(Note note) {
        try {
            noteRepository.save(note);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean update(Note note) {
        try {
            noteRepository.save(note);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean delete(long id) {
        try {
            Note note = noteRepository.findById(id);
            noteRepository.delete(note);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public List<NoteModel> getNotes() {
        List<Note> notes = noteRepository.findAll();
        return converter.convertList(notes);
    }

    public List<NoteModel> getNotes(Pageable pageable) {
        return converter.convertList(noteRepository.findAll(pageable).getContent());
    }

    public int getTotalPages(Pageable pageable) {
       return noteRepository.findAll(pageable).getTotalPages();
    }

    public NoteModel getByNameAndTitle(String name, String title) {
        return new NoteModel(noteRepository.findByNameAndTitle(name, title));
    }

    public List<NoteModel> getByTitle(String title) {
        return converter.convertList(noteRepository.findByTitle(title));
    }

    public Note getNote(long id) {
        return noteRepository.findById(id);
    }

    public Note getNote(String name) {
        return noteRepository.findByName(name);
    }
}
