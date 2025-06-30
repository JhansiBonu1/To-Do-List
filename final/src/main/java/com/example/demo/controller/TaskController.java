package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RequestMapping("/api/task")
@RestController
public class TaskController {
   @Autowired
   TaskRepository tr;

    @Autowired
    TaskService tservice;

    @PostMapping("/add")
    public ResponseEntity<?> a(@RequestBody Task task) {
        String res = tservice.addTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> g() {
        List<Task> data = tservice.getAll();
        return ResponseEntity.ok(data);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> d(@PathVariable int id) {
      String val=tservice.delUSer(id);
    return ResponseEntity.ok(val);
}
    @PutMapping("/update/{id}")
    ResponseEntity<?> u(@PathVariable int id,@RequestBody Task t)
    {
     Task existtask = tr.findById(id).orElse(null);
     existtask.setTitle(t.getTitle());
     existtask.setDescription(t.getDescription());
     existtask.setDuDate(t.getDuDate());
     existtask.setCompleted(t.getCompleted());
     tr.save(existtask);
     return ResponseEntity.ok("updated...");
    }
}
