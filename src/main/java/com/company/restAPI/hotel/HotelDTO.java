package com.company.restAPI.hotel;

public class HotelDTO {
	
	public HotelDTO() {
		super();
	}
	
	public HotelDTO(String hotelName, float hotelRating, String hotelAddress, int hotelPinCode) {
		super();
		this.hotelName = hotelName;
		this.hotelRating = hotelRating;
		this.hotelAddress = hotelAddress;
		this.hotelPinCode = hotelPinCode;
	}

	private int hotelId;
	private String hotelName;
	private float hotelRating;
	private String hotelAddress;
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

