package dev.ifrs.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @NoArgsConstructor @Setter @Getter
public class User extends PanacheEntity{
    private String name;

     @OneToMany(fetch = FetchType.EAGER)
     @JoinColumn(name = "usario_id")
     private List<Message> messages;
   
     @ManyToMany(fetch = FetchType.EAGER)
     private List<Channel> channels;

   

    public void addMessage(Message message) {
        this.messages.add(message);
    }
    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }
}
