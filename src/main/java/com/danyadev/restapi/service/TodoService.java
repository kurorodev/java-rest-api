package com.danyadev.restapi.service;

import com.danyadev.restapi.Entity.TodoEntity;
import com.danyadev.restapi.Entity.UserEntity;
import com.danyadev.restapi.model.Todo;
import com.danyadev.restapi.repository.TodoRepo;
import com.danyadev.restapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long Id){
        TodoEntity todo = todoRepo.findById(Id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
