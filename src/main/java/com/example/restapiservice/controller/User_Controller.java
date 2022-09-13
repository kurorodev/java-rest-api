package com.example.restapiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapiservice.repository.UserRepo;

import entity.UserEntity;

@RestController
@RequestMapping
public class User_Controller {
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/users/")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userRepo.save(user);
            return ResponseEntity.ok("Пользователь был успешно сохранен");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }



    @GetMapping("/users/")
    public ResponseEntity getUsers(){
        try {
            return ResponseEntity.ok("Сервер работает");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
