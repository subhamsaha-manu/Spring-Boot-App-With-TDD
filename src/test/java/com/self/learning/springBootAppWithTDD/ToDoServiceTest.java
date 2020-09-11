package com.self.learning.springBootAppWithTDD;

import com.self.learning.springBootAppWithTDD.entity.ToDo;
import com.self.learning.springBootAppWithTDD.repository.ToDoRepository;
import com.self.learning.springBootAppWithTDD.service.ToDoService;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @AfterEach
    void tearDown(){
        toDoRepository.deleteAll();
    }
    @Test
    void getAllToDos(){
        ToDo todoSample = new ToDo(1L,"Todo Sample 1",true);
        toDoRepository.save(todoSample);
        ToDoService toDoService = new ToDoService(toDoRepository);

        List<ToDo> toDoList = toDoService.findAll();
        ToDo lastToDo = toDoList.get(toDoList.size()-1);

        assertEquals(todoSample.getText(), lastToDo.getText());
        assertEquals(todoSample.isCompleted(), lastToDo.isCompleted());
        //assertEquals(todoSample.getId(), lastToDo.getId());
    }

    @Test
    void saveToDo(){
        ToDoService toDoService = new ToDoService(toDoRepository);
        ToDo toDoSample = new ToDo(1L,"Todo Sample 1",true);

        toDoService.save(toDoSample);

        assertEquals(1,toDoRepository.count());
    }

    @Test
    void deleteTodos(){
        ToDoService toDoService = new ToDoService(toDoRepository);
        ToDo toDoSample = new ToDo(1L,"Todo Sample 1",true);
        ToDo toDoSample2 = new ToDo(2L,"Todo Sample 2",false);

        toDoService.save(toDoSample);
        toDoService.save(toDoSample2);
        toDoSample2.setText("Sample 3");
        toDoSample2.setCompleted(true);
        toDoService.save(toDoSample2);
        List<ToDo> toDoList = new ArrayList<>();
        toDoList.add(toDoSample);
        toDoService.deleteAll(toDoList);

        assertEquals(1,toDoRepository.count());
        assertEquals("Sample 3",toDoRepository.findById(2L).get().getText());
    }
}
