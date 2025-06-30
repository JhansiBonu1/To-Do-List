package com.example.demo.model;

import java.time.LocalDate;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String description;
    LocalDate duDate;
    boolean completed = false;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)   //foreign key  nullable=false=> can't be null same as notnull in mysql
     Users user;
     
    public void setUser(Users u){
        this.user=u;
    }
    public void setTitle(String t){
        this.title=t;
    }
    public void setDescription(String d){
        this.description=d;
    }

    public void setDuDate(LocalDate dd){
        this.duDate=dd;
    }
    public void setCompleted(boolean c){
        this.completed=c;
    }
    public boolean getCompleted(){
        return this.completed;
    }
    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public LocalDate getDuDate(){
        return this.duDate;
    }
    
    
    




}
