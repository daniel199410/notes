package com.notes.core.converter;

import com.notes.core.entity.Note;
import com.notes.core.model.NoteModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("converter")
public class Converter {
    public List<NoteModel> convertList(List<Note> notes) {
        List<NoteModel> notesModel = new ArrayList<>();
        for(Note note : notes) {
            notesModel.add(new NoteModel(note));
        }
        return notesModel;
    }
}
