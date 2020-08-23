package com.self.learning.springBootAppWithTDD.service;


import com.self.learning.springBootAppWithTDD.entity.ToDo;
import com.self.learning.springBootAppWithTDD.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ToDoService {

    @Qualifier("toDoRepository")
    @Autowired
    private ToDoRepository toDoRepository;

    public ToDoService(@Qualifier("toDoRepository") ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }
}
