package com.example.ToDoRest.controller;

import com.example.ToDoRest.model.Task;
import com.example.ToDoRest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.listAllTask();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        try{
            Task task = taskService.getTaskById(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void saveTask(@RequestBody Task task){
        taskService.saveTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task task){
        try{
            Task updatedTask = taskService.getTaskById(id);
            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            taskService.saveTask(updatedTask);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "Task was deleted";
    }

}
