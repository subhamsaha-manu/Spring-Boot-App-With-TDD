package com.self.learning.springBootAppWithTDD.entity;

import javax.persistence.Entity;

@Entity
public class ToDo {

    private long id;
    private String text;
    private boolean isCompleted;

    public ToDo(long id, String text, boolean isCompleted) {
        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
    }
}
