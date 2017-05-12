package com.waa.airline.api.binder;

import com.waa.airline.api.controller.FlightController;
import com.waa.airline.api.dao.FlightDao;
import com.waa.airline.api.service.FlightService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * Created by 985552 on 5/12/2017.
 */
public class FlightBinder extends AbstractBinder{
    protected void configure() {
        bind(new FlightService(new FlightDao())).to(FlightService.class);
    }
}
