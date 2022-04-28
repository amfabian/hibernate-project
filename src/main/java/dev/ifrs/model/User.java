package dev.ifrs.model;

import javax.persistence.Entity;

@Entity
public class User {
    private String name;

   
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
