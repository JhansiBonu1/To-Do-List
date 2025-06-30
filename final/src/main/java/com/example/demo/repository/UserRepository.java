package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Users;
//import java.util.List;


public interface UserRepository extends JpaRepository<Users,Integer> {

    public Users findByEmail(String email);
    public Users findById(int id);
}
