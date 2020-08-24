package com.self.learning.springBootAppWithTDD.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class ToDo {

    @Id
    @GeneratedValue
    private long id;
    private String text;
    private boolean completed;

    public ToDo(long id, String text, boolean completed) {
        this.id = id;
        this.text = text;
        this.completed = completed;
    }

    public ToDo(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
    }

}
