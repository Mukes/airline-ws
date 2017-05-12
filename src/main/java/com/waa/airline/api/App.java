package com.waa.airline.api;

import com.waa.airline.api.dao.FlightDao;
import com.waa.airline.api.model.Airline;
import com.waa.airline.api.model.Airplane;
import com.waa.airline.api.model.Airport;
import com.waa.airline.api.model.Flight;
import com.waa.airline.api.nonmanaged.JpaUtil;
import com.waa.airline.api.service.FlightService;
import org.apache.log4j.Logger;

import java.util.List;

public class App {
	private static Logger logger = Logger.getLogger(App.class);
	private FlightService flightService;

	public static void main(String[] args) {		
		App app = new App();
		app.run();
		
		// This is needed because not its not closing Hibernate's connection 
		// - use beans instead of instantiating the JPA directly
		JpaUtil.destroyJpaUtil();
		
	}

	// Init Services
	public App() {
		// Services should be injected -DI
		// all of these objects are singleton and application scoped
		flightService = new FlightService(new FlightDao());
	}

	public void run() {

		// fill the database
		fillDataBase();

		// Flights leaving USA capacity > 500

		logger.trace("List all the flights:");
		List<Flight> flights = flightService.findAll();
		logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:", "Arrives:"));
		for (Flight flight : flights) {
			logger.trace(String.format("%-7s  %-12s %7s %8s  %-12s %7s %8s", flight.getFlightnr(),
					flight.getOrigin().getCity(), flight.getDepartureDate(), flight.getDepartureTime(),
					flight.getDestination().getCity(), flight.getArrivalDate(), flight.getArrivalTime()));
		}
	}

	public void fillDataBase() {
		
		// There is a IMPORT.SQL script in resources that is executed before this code to fill up the database

		Airport mco = new Airport("MCO", "Orlando", "Florida", "USA");
		Airport mia = new Airport("MIA", "Miami", "Florida", "USA");

		Airplane airplane1 = new Airplane("56789", "A380", 519);

		Airline airline1 = new Airline("Delta");

		Flight flight1 = new Flight("DE 36", "08/06/2009", "7:10 pm",
				"06/25/2015", "9:00 am", airline1, mia, mco, airplane1);
		
		flightService.create(flight1);
	}
}
