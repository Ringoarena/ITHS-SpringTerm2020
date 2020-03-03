package rest;

import dao.MessageDAO;
import model.Message;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/messages")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MessageResource {
    @Inject
    MessageDAO messageDAO;

    @POST
    public Response add(Message message) {
        messageDAO.create(message);
        return Response.ok().entity(message).build();
    }

    @GET
    public Response getMessages(@Context HttpServletRequest req, @HeaderParam("lastId") Long lastID) {
        System.out.println(req.getRemoteAddr() + " last ID is: " + lastID);
        return Response.ok().entity(messageDAO.getAll(lastID)).build();
    }
}