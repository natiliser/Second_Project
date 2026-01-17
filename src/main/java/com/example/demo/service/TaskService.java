package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class TaskService {
    @Autowired
    TaskRepository repository;

    public Iterable<Task> all() {
        return repository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public void delete(Task task) {
        repository.delete(task);
    }
}
