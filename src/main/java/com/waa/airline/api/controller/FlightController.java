package com.waa.airline.api.controller;

import com.waa.airline.api.dao.FlightDao;
import com.waa.airline.api.model.Flight;
import com.waa.airline.api.service.FlightService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by 985552 on 5/12/2017.
 */
@Path("/flight")
public class FlightController {
    @Inject
    private FlightService flightService;
    /*public FlightController(){
        flightService = new FlightService(new FlightDao());
    }*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlights(){
        List<Flight> flights = flightService.findAll();
        if (flights.size()>0){
            return Response.ok(flights, MediaType.APPLICATION_JSON).build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/{flightNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccounts(@PathParam("flightNo") String flightNo){
        List<Flight> flights = flightService.findByNumber(flightNo);
        if (flights.size()>0){
            return Response.ok(flights, MediaType.APPLICATION_JSON).build();
        }
        return Response.noContent().build();
    }
}
