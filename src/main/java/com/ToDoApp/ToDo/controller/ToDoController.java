package com.ToDoApp.ToDo.controller;

import com.ToDoApp.ToDo.entity.ToDo;
import com.ToDoApp.ToDo.service.ToDoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")

public class ToDoController
{
    @Autowired
    private ToDoServiceImpl toDoService;

    @GetMapping
    public List<ToDo> findAll()
    {
        return toDoService.getAllToDo();
    }

    @PostMapping
    public void save(@RequestBody ToDo toDo)
    {
        toDoService.saveToDo(toDo);
    }

    @GetMapping("/{id}")
    public ToDo findOne(@PathVariable Long id)
    {
        return toDoService.getTodoById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ToDo toDo)
    {
        this.toDoService.updateToDo(id, toDo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        this.toDoService.deleteTodo(id);
    }

}
