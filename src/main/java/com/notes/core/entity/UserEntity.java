package com.notes.core.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name="USERNAME", unique=true)
    private String userName;
    private String password;
    private byte rol;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getRol() {
        return rol;
    }

    public void setRol(byte rol) {
        this.rol = rol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;
}
