package com.ToDoApp.ToDo.repository;

import com.ToDoApp.ToDo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {


}
