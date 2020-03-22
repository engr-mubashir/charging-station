package io.hubject.chargingstation.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Lenovo
 *
 */
@Entity
public class Station {

	@Id
	private String stationId;
	private String latitude;
	private String longitude;
	private String postalCode;

	// Added to resolve InvalidDefinitionException thrown by
	// com.fasterxml.jackson.databind
	public Station() {

	}

	public Station(String stationId, String latitude, String longitude, String postalCode) {
		super();
		this.stationId = stationId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.postalCode = postalCode;
	}

	/**
	 * @return the stationId
	 */
	public String getStationId() {
		return stationId;
	}

	/**
	 * @param stationId
	 *            the stationId to set
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
