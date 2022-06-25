package com.company.restAPI.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Hotel {
	
	public Hotel() {
		super();
	}
	
	public Hotel(String hotelName, @Max(5) @Min(0) float hotelRating, String hotelAddress,
			@Min(100000) @Max(999999) int hotelPinCode) {
		super();
		this.hotelName = hotelName;
		this.hotelRating = hotelRating;
		this.hotelAddress = hotelAddress;
		this.hotelPinCode = hotelPinCode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hotelId;
	private String hotelName;

	@Max(5)
	@Min(0)
	private float hotelRating;

	private String hotelAddress;

	@Min(100000)
	@Max(999999)
	private int hotelPinCode;

	public int getHotelPinCode() {
		return hotelPinCode;
	}

	public void setHotelPinCode(int hotelPinCode) {
		this.hotelPinCode = hotelPinCode;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public float getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(float hotelRating) {
		this.hotelRating = hotelRating;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public int getHotelId() {
		return hotelId;
	}
}
