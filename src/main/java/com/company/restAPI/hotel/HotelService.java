package com.company.restAPI.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

	@Autowired
	private HotelRepository repo;

	private Logger logger = LoggerFactory.getLogger(HotelService.class);

	public List<Hotel> getAllHotels() {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		repo.findAll().forEach(hotelList::add);
		return hotelList;
	}

	public Hotel getHotel(int id) {
		Hotel hotel = null;
		try {
			hotel = repo.findById(id).get();
		} catch (NoSuchElementException e) {
			logger.error(e.getMessage());
		}
		return hotel;
	}

	public void addHotel(Hotel hotel) {
		repo.save(hotel);
	}

	public boolean updateHotel(Hotel hotel) {
		Hotel existingHotel = getHotel(hotel.getHotelId());
		if (existingHotel != null) {
			if (hotel.getHotelAddress() != null) {
				existingHotel.setHotelAddress(hotel.getHotelAddress());
			}
			if (hotel.getHotelPinCode() > 0) {
				existingHotel.setHotelPinCode(hotel.getHotelPinCode());
			}
			if (hotel.getHotelRating() > 0) {
				existingHotel.setHotelRating(hotel.getHotelRating());
			}
			if (hotel.getHotelName() != null) {
				existingHotel.setHotelName(hotel.getHotelName());
			}
			repo.save(existingHotel);
			return true;
		}
		return false;
	}
	
	public boolean updateHotelUsingForm(int id, String hotelName, String hotelRating, String hotelAddress, String hotelPinCode) {
		Hotel existingHotel = getHotel(id);
		if (existingHotel != null) {
			if (!hotelAddress.isBlank()) {
				existingHotel.setHotelAddress(hotelAddress);
			}
			if (!hotelPinCode.isEmpty() && Integer.parseInt(hotelPinCode) > 0) {
				existingHotel.setHotelPinCode(Integer.parseInt(hotelPinCode));
			}
			if (!hotelRating.isEmpty() && Float.parseFloat(hotelRating) > 0) {
				existingHotel.setHotelRating(Float.parseFloat(hotelRating));
			}
			if (!hotelName.isBlank()) {
				existingHotel.setHotelName(hotelName);
			}
			repo.save(existingHotel);
			return true;
		}
		return false;
	}

	public boolean deleteHotel(int id) {
		Hotel existingHotel = getHotel(id);
		if (existingHotel != null) {
			repo.delete(existingHotel);
			return true;
		}
		return false;
	}
}
