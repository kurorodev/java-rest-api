package com.danyadev.restapi.service;

import com.danyadev.restapi.Entity.UserEntity;
import com.danyadev.restapi.exception.UserAlreadyExist;
import com.danyadev.restapi.exception.UserNotFound;
import com.danyadev.restapi.model.User;
import com.danyadev.restapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExist{
        if(userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExist("Пользователь с таким именем уже существует!");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFound {
        UserEntity userGet = userRepo.findById(id).get();
        if(userGet == null){
            throw new UserNotFound("Пользователя с таким ID не существует!");
        }
        return User.toModel(userGet);
    }

    public Long deleteUser(Long id) throws UserNotFound {
        if (id  == null) {
            throw new UserNotFound("Пользователя с таким ID не существует!");
        }
        userRepo.deleteById(id);
        return id;
    }

}
