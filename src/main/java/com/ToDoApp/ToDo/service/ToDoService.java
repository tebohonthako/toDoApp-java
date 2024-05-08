package com.ToDoApp.ToDo.service;

import com.ToDoApp.ToDo.entity.ToDo;

import java.util.List;

public interface ToDoService {

    // start with our model
    List <ToDo> getAllToDo();

    // we want to save not return anything hence use void
    // parameters we tell it what we expect - our model and object ...
    void saveToDo(ToDo todo);

    // we need id from our db and save new data to out model - need a return type
    // creating a new object based on our model
    ToDo updateToDo(Long id, ToDo todo);

    ToDo getTodoById(Long id);

    //want to delete
    void deleteTodo(Long id);

}
