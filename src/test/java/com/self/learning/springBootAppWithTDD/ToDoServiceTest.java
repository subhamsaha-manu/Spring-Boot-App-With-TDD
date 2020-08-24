package com.self.learning.springBootAppWithTDD;

import com.self.learning.springBootAppWithTDD.entity.ToDo;
import com.self.learning.springBootAppWithTDD.repository.ToDoRepository;
import com.self.learning.springBootAppWithTDD.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    void getAllToDos(){
        ToDo toDoSample = new ToDo(1L,"Todo Sample 1",true);
        toDoRepository.save(toDoSample);
        ToDoService toDoService = new ToDoService(toDoRepository);

        ToDo firstToDo = toDoService.findAll().get(0);
        assertEquals(toDoSample.getText(),firstToDo.getText());
        assertTrue(firstToDo.isCompleted());
    }
}
