package com.self.learning.springBootAppWithTDD;

import com.self.learning.springBootAppWithTDD.entity.ToDo;
import com.self.learning.springBootAppWithTDD.repository.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAppWithTddApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppWithTddApplication.class, args);

	}
}
