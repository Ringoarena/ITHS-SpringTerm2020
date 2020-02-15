package rest;

import model.Calculator;
import model.Result;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/calculator")
public class CalculatorService {
    @Inject
    private Calculator calculator;

    @GET
    @Path("/add/{i1}/{i2}")
    @Produces({"application/xml", "application/json"})
    public Result add(@PathParam("i1") int i1, @PathParam("i2") int i2) {
        return calculator.addition(i1, i2);
    }

    @POST
    @Path("/add")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json"})
    public Result add(IntegerPair pair) {
        return calculator.addition(pair.getI1(), pair.getI2());
    }
}
