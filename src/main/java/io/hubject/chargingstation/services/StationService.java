package io.hubject.chargingstation.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hubject.chargingstation.models.Station;
import io.hubject.chargingstation.resources.StationRepository;

/**
 * @author Lenovo
 *
 */
@Service
public class StationService {

	@Autowired
	private StationRepository stationRepository;

	public List<Station> getAllStations() {
		List<Station> stations = new ArrayList<>();
		stationRepository.findAll().forEach(stations::add);
		return stations;
	}

	public Station getStationById(String stationId) {
		return stationRepository.findById(stationId).orElse(null);
	}

	public List<Station> getStationsByPostalCode(String postalCode) {
		return stationRepository.findByPostalCode(postalCode);
	}

	public List<Station> getPerimeterByLocation(String latitude, String longitude) {
		return stationRepository.findPerimeterAroundLocation(latitude, longitude);
	}

	public void addStation(Station station) {
		stationRepository.save(station);
	}
}
