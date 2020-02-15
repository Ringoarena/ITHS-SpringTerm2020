package rest;

import model.CurrentTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/time")
public class TimeService {

    @GET
    @Path("/current")
    @Produces({"application/xml", "application/json"})
    public CurrentTime getCurrentTime() {
        return new CurrentTime();
    }
}
