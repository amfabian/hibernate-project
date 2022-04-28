package dev.ifrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dev.ifrs.model.User;

@Path("/api")
public class Service {

    @GET
    @Path("/user/create/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User creatUser(@PathParam("name") String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

}
