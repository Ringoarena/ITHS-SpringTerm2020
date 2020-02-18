package rest;

import model.Person;
import model.PersonDAO;
import model.PersonList;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonService {
    @Inject
    PersonDAO personDAO;

    @GET
    public Response ping() {
        return Response.ok("5 by 5")
                .build();
    }

    @GET
    @Path("/add/{name}")
    public String add(@PathParam("name") String name) {
        personDAO.add(new Person(name));
        return name + " added.";
    }

    @POST
    @Path("/add")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json"})
    public String add2(Person person) {
        personDAO.add(person);
        return person.getName() + " added via POST";
    }

    @GET
    @Path("/all")
    @Produces({"application/xml", "application/json"})
    public PersonList getPersonList() {
        System.out.println("getPersonList() called.");
        return new PersonList(personDAO.getAll());
    }
}
