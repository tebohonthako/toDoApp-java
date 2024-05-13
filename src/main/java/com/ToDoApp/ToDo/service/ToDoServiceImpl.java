package com.ToDoApp.ToDo.service;


import com.ToDoApp.ToDo.entity.ToDo;
import com.ToDoApp.ToDo.repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service   //specify that this is a service only done in implementation of the service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    private ToDoRepo toDoRepo;


    @Override   // we want to override the methods wwe have in service ...
    public List<ToDo> getAllToDo(){
        return toDoRepo.findAll();  //jpa db facilitates communication between repo and db // return type is a list of todo

    }

    @Override
    public void saveToDo(ToDo todo) {
        this.toDoRepo.save(todo);
    }

    @Override
    public ToDo getTodoById(Long id) {  //return type of todo_ is expected
        Optional<ToDo> optional = toDoRepo.findById(id);  // making optional to fetch by id
        ToDo toDo;
        if (optional.isPresent()) {
            toDo = optional.get();  // getting sneakers from another store that has them in stock.
        } else {
            throw new RuntimeException("To for the id " + id + "is not found");
        }
        return toDo;
    }

    @Override
    public void updateToDo(Long id, ToDo toDo){
        ToDo todoFromDb = toDoRepo.findById(id).get();
        todoFromDb.setTaskName(toDo.getTaskName());
        todoFromDb.setDescription(toDo.getDescription());
        toDoRepo.save(todoFromDb);
    }

    @Override
    public void deleteTodo(Long id) {

    }

}
