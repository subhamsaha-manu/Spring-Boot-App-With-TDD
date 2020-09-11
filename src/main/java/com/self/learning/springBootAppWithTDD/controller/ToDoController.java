package com.self.learning.springBootAppWithTDD.controller;

import com.self.learning.springBootAppWithTDD.entity.ToDo;
import com.self.learning.springBootAppWithTDD.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todos")
    ResponseEntity<List<ToDo>> getAllTodos(){
        return new ResponseEntity<>(toDoService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/todos")
    ResponseEntity<ToDo> create(@RequestBody ToDo toDo) {
        return new ResponseEntity<>(toDoService.save(toDo), HttpStatus.CREATED);
    }

    @PutMapping("/todos")
    ResponseEntity<ToDo> delete(@RequestBody List<ToDo> toDoList) {
        toDoService.deleteAll(toDoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
