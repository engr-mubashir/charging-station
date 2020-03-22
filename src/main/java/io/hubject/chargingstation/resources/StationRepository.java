package io.hubject.chargingstation.resources;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.hubject.chargingstation.models.Station;

/**
 * @author Lenovo
 *
 */
public interface StationRepository extends CrudRepository<Station, String> {

	public List<Station> findByPostalCode(String postalCode);

	@Query(value = "SELECT * FROM Station s WHERE ACOS((SIN(RADIANS(CAST(s.latitude as DECIMAL(9, 2)))) * SIN(RADIANS(CAST(:latitude as DECIMAL(9, 2))))) + (COS(RADIANS(CAST(s.latitude as DECIMAL(9, 2)))) * COS(RADIANS(CAST(:latitude as DECIMAL(9, 2))))) * COS(RADIANS(CAST(s.longitude as DECIMAL(9, 2))) - RADIANS(CAST(:longitude as DECIMAL(9, 2))))) * 6380 <= 5", nativeQuery = true)
	public List<Station> findPerimeterAroundLocation(@Param("latitude") String latitude,
			@Param("longitude") String longitude);
}
