package dev.ifrs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class User extends PanacheEntity{
    private String name;

     @OneToMany
     @JoinColumn(name = "usario_id")
     private List<Message> messages;
   
     @ManyToMany
     private List<Channel> channels;

    // public User() {
    //    this.messages = new ArrayList<>();
    //    this.channels = new ArrayList<>();
    // }

    public void addMessage(Message message) {
        this.messages.add(message);
     
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
