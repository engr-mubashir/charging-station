package io.hubject.chargingstation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.hubject.chargingstation.models.Station;
import io.hubject.chargingstation.services.StationService;

/**
 * @author Lenovo
 *
 */
@RestController
public class StationController {

	@Autowired
	private StationService stationService;

	@RequestMapping("/stations")
	public List<Station> getAllStations() {
		return stationService.getAllStations();
	}

	@RequestMapping("/stations/{stationId}")
	public Station getStationById(@PathVariable("stationId") String stationId) {
		return stationService.getStationById(stationId);
	}

	@RequestMapping("/stations/code/{postalCode}")
	public List<Station> getStationsByPostalCode(@PathVariable("postalCode") String postalCode) {
		return stationService.getStationsByPostalCode(postalCode);
	}

	@RequestMapping("/stations/location/{latitude}/{longitude}")
	public List<Station> getPerimeterByLocation(@PathVariable("latitude") String latitude,
			@PathVariable("longitude") String longitude) {
		return stationService.getPerimeterByLocation(latitude, longitude);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/stations")
	public void addStation(@RequestBody Station station) {
		stationService.addStation(station);
	}
}
