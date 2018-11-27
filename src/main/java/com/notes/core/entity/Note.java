package com.notes.core.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="NOTE")
@Entity
public class Note implements Serializable {
    @GeneratedValue
    @Id
    @Column(name="ID")
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="TITLE")
    private String title;

    @Column(name="CONTENT")
    private String content;

    public Note() {
    }

    public Note(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
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
