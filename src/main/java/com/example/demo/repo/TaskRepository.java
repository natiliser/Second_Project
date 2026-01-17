package com.example.demo.repo;
import com.example.demo.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long> {



}
