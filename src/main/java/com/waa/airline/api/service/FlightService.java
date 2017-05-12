package com.waa.airline.api.service;


import com.waa.airline.api.dao.FlightDao;
import com.waa.airline.api.model.Airline;
import com.waa.airline.api.model.Airplane;
import com.waa.airline.api.model.Airport;
import com.waa.airline.api.model.Flight;

import java.util.Date;
import java.util.List;

public class FlightService {
	private FlightDao flightDao;
	
	// These services should be evaluated to reconsider which methods should be public 
	
	public FlightService(FlightDao flightDao){
		this.flightDao = flightDao;
	}
	
	public void create(Flight flight) {
		flightDao.create(flight);
	}

	public void delete(Flight flight) {
		flightDao.delete(flight);
	}

	public Flight update(Flight flight) {
		return flightDao.update(flight);
	}
		
	public Flight find(Flight flight) {
		return flightDao.findOne(flight.getId());
	}

	public List<Flight> findByNumber(String flightnr) {
		return flightDao.findByFlightnr(flightnr);
	}

	public List<Flight> findByAirline(Airline airline) {
		return flightDao.findByAirline(airline.getId());
	}

	public List<Flight> findByOrigin(Airport airport) {
		return flightDao.findByOrigin(airport.getId());
	}

	public List<Flight> findByDestination(Airport airport) {
		return flightDao.findByDestination(airport.getId());
	}

	public List<Flight> findByArrival(Airplane airplane) {
		return flightDao.findByAirplane(airplane.getId());
	}

	public List<Flight> findByArrival(Date datetime) {
		return flightDao.findByArrival(datetime, datetime);
	}

	public List<Flight> findByArrivalBetween(Date datetimeFrom, Date datetimeTo) {
		return flightDao.findByArrivalBetween(datetimeFrom, datetimeFrom, datetimeTo, datetimeTo);
	}

	public List<Flight> findByDeparture(Date datetime) {
		return flightDao.findByDeparture(datetime, datetime);
	}

	public List<Flight> findByDepartureBetween(Date datetimeFrom, Date datetimeTo) {
		return flightDao.findByDepartureBetween(datetimeFrom, datetimeFrom, datetimeTo, datetimeTo);
	}

	public List<Flight> findAll() {
		return flightDao.findAll();
	}

}
