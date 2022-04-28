package dev.ifrs.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class User extends PanacheEntity{
    private String name;

   
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
