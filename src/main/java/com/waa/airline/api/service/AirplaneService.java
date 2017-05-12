package com.waa.airline.api.service;

import com.waa.airline.api.dao.AirplaneDao;
import com.waa.airline.api.model.Airplane;
import com.waa.airline.api.model.Flight;

import java.util.List;

public class AirplaneService {

	// These services should be evaluated to reconsider which methods should be public 

	private AirplaneDao airplaneDao;

	public AirplaneService(AirplaneDao airplaneDao) {
		this.airplaneDao = airplaneDao;
	}

	public void create(Airplane airplane) {
		airplaneDao.create(airplane);
	}

	public void delete(Airplane airplane) {
		airplaneDao.delete(airplane);
	}

	public Airplane update(Airplane airplane) {
		return airplaneDao.update(airplane);
	}

	public Airplane find(Airplane airplane) {
		return airplaneDao.findOne(airplane.getId());
	}

	public Airplane findBySrlnr(String serialno) {
		return airplaneDao.findOneBySerialnr(serialno);
	}

	public List<Airplane> findByFlight(Flight flight) {
		return airplaneDao.findByFlight(flight.getId());
	}

	public List<Airplane> findByModel(String model) {
		return airplaneDao.findByModel(model);
	}

	public List<Airplane> findAll() {
		return airplaneDao.findAll();
	}

}
