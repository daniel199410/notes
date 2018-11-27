package com.notes.core.model;

import com.notes.core.entity.Note;

public class NoteModel {

    private long id;
    private String name;
    private String title;
    private String content;

    public NoteModel(long id, String name, String title, String content) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public NoteModel(Note note) {
        this.id = note.getId();
        this.name = note.getName();
        this.title = note.getTitle();
        this.content = note.getContent();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
