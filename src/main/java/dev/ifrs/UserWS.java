package dev.ifrs;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.model.Channel;
import dev.ifrs.model.User;

@Path("/user")
@Transactional
public class UserWS {

    @GET
    @Path("/save/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User save(@PathParam("name") String name) {
        User user = new User();
        user.setName(name);
        // 2 - O método do Panache `persist` possibilita persistir um objeto.
        user.persist();
        return user;
    }


    @GET
    @Path("/save/{name}/{channel}")
    @Produces(MediaType.APPLICATION_JSON)
    public User save(@PathParam("name") String name, @PathParam("channel") Long id_channel){
        User user = new User();
        user.setName(name);
        Channel ch = Channel.findById(id_channel);
        user.addChannel(ch);
        user.persist();
        return user;
    }
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<User> list() {
        return User.listAll();
    }
    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public User list(@PathParam("id") Long id) {
        // 4 - O método do Panache `findById` recupera um objeto da classe User.
        return User.findById(id);
    }
    
}
