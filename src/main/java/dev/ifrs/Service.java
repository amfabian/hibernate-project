package dev.ifrs;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.model.Channel;
import dev.ifrs.model.Message;
import dev.ifrs.model.User;

@Path("/api")
@Transactional
public class Service {

    @GET
    @Path("/user/create/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User creatUser(@PathParam("name") String name) {
        User user = new User();
        user.setName(name);
        user.persist();
        return user;
    }

    @GET
    @Path("/message/create/{text}/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message createMessage (@PathParam("text") String text, @PathParam("user_id") Long user_id) {
           
        Message message = new Message();
        message.setText(text);
        message.persist();

        User user = User.findById(user_id);
       
        user.addMessage(message);
        user.persist();
        return message;               
    }
    @GET
    @Path("/channel/create/{hash}")
    @Produces(MediaType.APPLICATION_JSON)
    public Channel createChannel (@PathParam("hash") String hash) {
        Channel channel = new Channel();
        channel.setHash(hash);
        channel.persist();
        return channel;               
    }



}
