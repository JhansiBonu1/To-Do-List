package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.model.Users;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class TaskService {
     @Autowired
     HttpSession session;
    @Autowired
    TaskRepository tr;
    @Autowired
    UserRepository ur;
    
   public String addTask(Task t)
   {
     
     Integer id=(Integer)session.getAttribute("LoggedInUser");
      if(id==null)
      {
         return "user not logged in";
      }
      Users user =ur.findById(id).orElse(null);
      if(user==null)
      {
        return "Invalid user";
      }
      t.setUser(user);
      tr.save(t);
      return "Task Added";
   }
  public List<Task> getAll()
  {
    Integer id=(Integer)session.getAttribute("LoggedInUser");
    Users user = ur.findById(id).orElse(null);
    List<Task> data = tr.findByUser(user);
    return data;
      }
  public String delUSer(int id) {
      Task user=tr.findById(id).orElse(null);
      tr.delete(user);
      return "deleted";
  }
}
