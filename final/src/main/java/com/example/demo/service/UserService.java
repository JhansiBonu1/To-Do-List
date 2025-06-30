package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
   HttpSession session;  
   @Autowired
    UserRepository ur;
   public String registerUser(Users user)
   {
      Users existuser = ur.findByEmail(user.getEmail());
      if(existuser != null)
      {
        return "Email already exists";
      }
      ur.save(user);
      return "User registered successfully";
   }
public String userLogin(Users user)
{
  Users existuser= ur.findByEmail(user.getEmail());
  if(existuser != null && existuser.getPassword().equals(user.getPassword()))
  {   
      session.setAttribute("LoggedInUser",existuser.getId());
      return "Login successfull";
  }
  return "Invalid credentials";
  
}

}
