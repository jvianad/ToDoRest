package com.example.ToDoRest.repository;

import com.example.ToDoRest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iTaskRepository extends JpaRepository<Task,Long> {
}
