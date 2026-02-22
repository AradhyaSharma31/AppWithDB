package com.example.demo.service.impl;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepo;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public void createTask(String task, String description) {
        Task newTask = new Task();
        newTask.setTask(task);
        newTask.setDescription(description);
        taskRepo.save(newTask);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public void updateTask(Long id, String task, String description) {
        Task existingTask = getTaskById(id);
        if (existingTask != null) {
            existingTask.setTask(task);
            existingTask.setDescription(description);
            taskRepo.save(existingTask);
        }
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
