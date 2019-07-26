package com.datahan.server.malta.repository;

import com.datahan.server.malta.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, String> {
}
