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
    private boolean isCompleted;

    public ToDo(long id, String text, boolean isCompleted) {
        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
    }

}
