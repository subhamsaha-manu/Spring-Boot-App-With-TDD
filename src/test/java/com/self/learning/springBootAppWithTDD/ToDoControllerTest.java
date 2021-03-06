package com.self.learning.springBootAppWithTDD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.learning.springBootAppWithTDD.entity.ToDo;
import com.self.learning.springBootAppWithTDD.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class ToDoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Test
    public void getAllTodos() throws Exception {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(new ToDo(1L, "Create Portfolio Application", true));
        toDoList.add(new ToDo(2L, "Spring Boot app with TDD", false));
        when(toDoService.findAll()).thenReturn(toDoList);
        mockMvc.perform(MockMvcRequestBuilders.get("/todos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
    }

    @Test
    public void successfullySaveATodo() throws Exception {
        ToDo practiceFootballTodo = new ToDo("Practice Football", false);
        when(toDoService.save(practiceFootballTodo)).thenReturn(practiceFootballTodo);
        ObjectMapper objectMapper = new ObjectMapper();
        String practiceFootballTodoJson =
                objectMapper.writeValueAsString(practiceFootballTodo);

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders.post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(practiceFootballTodoJson))
                        .andExpect(jsonPath("$.text").value("Practice Football"))
                        .andExpect(jsonPath("$.completed").value("false"))
                        .andExpect(status().isCreated());
    }

}
