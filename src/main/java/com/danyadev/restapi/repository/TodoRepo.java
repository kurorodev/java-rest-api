package com.danyadev.restapi.repository;

import com.danyadev.restapi.Entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
