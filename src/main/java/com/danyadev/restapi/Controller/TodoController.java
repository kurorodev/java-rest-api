package com.danyadev.restapi.Controller;

import com.danyadev.restapi.Entity.TodoEntity;
import com.danyadev.restapi.repository.TodoRepo;
import com.danyadev.restapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long Id) {
        try {
            return ResponseEntity.ok(todoService.completeTodo(Id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
