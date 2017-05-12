package com.waa.airline.api.feature;

import com.waa.airline.api.binder.FlightBinder;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Created by 985552 on 5/12/2017.
 */
public class FlightFeature implements Feature{
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(new FlightBinder());
        return true;
    }
}
