package com.example.ToDoRest.service;

import com.example.ToDoRest.model.Task;
import com.example.ToDoRest.repository.iTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private iTaskRepository taskRepository;

    public List<Task> listAllTask(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).get();
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }


}
