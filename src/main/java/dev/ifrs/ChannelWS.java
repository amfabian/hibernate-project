package dev.ifrs;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.model.Channel;

@Path("/channel")
@Transactional

public class ChannelWS {

    
   @GET
   @Path("/save/{hash}")
   @Produces(MediaType.APPLICATION_JSON)
   public Channel save(@PathParam("hash") String hash) {
      Channel channel = new Channel();
      channel.setHash(hash);
      channel.persist();
      return channel;
   }

    
}
