package com.example.demo.controller;

import com.example.demo.dto.TaskIn;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllTask() {
        return new ResponseEntity<>(taskService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneTask(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertTask(@RequestBody TaskIn taskIn) {
        Task task = taskIn.getTask(taskIn);
        task = taskService.save(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskIn taskIn) {
        Optional<Task> dbTask = taskService.findById(id);
        taskIn.setTask(dbTask.get());
        Task updatedTask = taskService.save(dbTask.get());
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Optional<Task> dbTask = taskService.findById(id);
        taskService.delete(dbTask.get());
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }
}
