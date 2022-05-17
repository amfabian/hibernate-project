package dev.ifrs.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor
public class Channel extends PanacheEntity {
    private String hash;
    
    @ManyToMany(mappedBy = "channels", fetch = FetchType.EAGER)
     private List<User> users;

     public void addUser(User user) {
        this.users.add(user);
    }
}

