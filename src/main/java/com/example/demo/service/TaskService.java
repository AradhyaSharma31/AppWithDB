package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {
    void createTask(String task, String description);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    void updateTask(Long id, String task, String description);
    void deleteTask(Long id);
}
