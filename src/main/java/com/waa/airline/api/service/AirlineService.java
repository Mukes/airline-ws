package com.waa.airline.api.service;


import com.waa.airline.api.dao.AirlineDao;
import com.waa.airline.api.model.Airline;
import com.waa.airline.api.model.Flight;

import java.util.List;

public class AirlineService {
	
	// These services should be evaluated to reconsider which methods should be public 

	private AirlineDao airlineDao;
	
	public AirlineService(AirlineDao airlineDao) {
		this.airlineDao=airlineDao;
	}

	public void create(Airline airport) {
		airlineDao.create(airport);
	}

	public void delete(Airline airport) {
		airlineDao.delete(airport);
	}

	public Airline update(Airline airport) {
		return airlineDao.update(airport);
	}
		
	public Airline find(Airline airport) {
		return airlineDao.findOne(airport.getId());
	}

	public Airline findByName(String name) {
		return airlineDao.findOneByName(name);
	}

	public List<Airline> findByFlight(Flight flight) {
		return airlineDao.findByFlight(flight.getId());
	}

	public List<Airline> findAll() {
		return airlineDao.findAll();
	}	
}
