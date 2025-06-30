package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Task;
import com.example.demo.model.Users;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByUser( Users u);
    
}
