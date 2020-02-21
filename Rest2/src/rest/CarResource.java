package rest;

import dao.CarDAO;
import model.Car;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/car")
public class CarResource {

    @Inject
    CarDAO carDAO;

    @GET
    public Response ping() {
        return Response.ok("Rest2, CarResource, 5 by 5").build();
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String add(Car car) {
        carDAO.create(car);
        return car.getBrand() + " " + car.getModel() + " added via POST";
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        carDAO.delete(id);
    }

    @GET
    @Path("/{id}")
    public Car getCar(@PathParam("id") Long id) {
        return carDAO.get(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Car> getAll() {
        return carDAO.getAll();
    }

    @PUT
    public void updateCar(Car car) {
        carDAO.updateCar(car);
    }
}
