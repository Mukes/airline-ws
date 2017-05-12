package com.waa.airline.api;

import com.waa.airline.api.controller.FlightController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 985552 on 5/12/2017.
 */
@ApplicationPath("/")
//The java class declares root resource and provider classes
public class AirlineApplication extends Application {
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add( HelloWorld.class );
        //h.add( FlightController.class );
        return h;
    }
}