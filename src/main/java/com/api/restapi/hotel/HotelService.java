package com.api.restapi.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

	@Autowired
	private HotelRepository repo;

	@Autowired
	private ModelMapper modelMapper;

	public List<Hotel> getAllHotels() {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		repo.findAll().forEach(hotelList::add);
		return hotelList;
	}

	public Hotel getHotel(int id) {
		Hotel hotel = null;
		Optional<Hotel> h = repo.findById(id);
		if (h.isPresent()) {
			hotel = h.get();
		}
		return hotel;
	}

	public void addHotel(HotelDTO hotelDTO) {
		Hotel hotel = modelMapper.map(hotelDTO, Hotel.class);
		repo.save(hotel);
	}

	public boolean updateHotel(HotelDTO hotelDTO) {
		Hotel existingHotel = getHotel(hotelDTO.getHotelId());
		if (existingHotel != null) {
			if (hotelDTO.getHotelAddress() != null) {
				existingHotel.setHotelAddress(hotelDTO.getHotelAddress());
			}
			if (hotelDTO.getHotelPinCode() > 0) {
				existingHotel.setHotelPinCode(hotelDTO.getHotelPinCode());
			}
			if (hotelDTO.getHotelRating() > 0) {
				existingHotel.setHotelRating(hotelDTO.getHotelRating());
			}
			if (hotelDTO.getHotelName() != null) {
				existingHotel.setHotelName(hotelDTO.getHotelName());
			}
			repo.save(existingHotel);
			return true;
		}
		return false;
	}

	public boolean updateHotelUsingForm(int id, String hotelName, String hotelRating, String hotelAddress,
			String hotelPinCode) {
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

	public Hotel deleteHotel(int id) {
		Hotel existingHotel = getHotel(id);
		if (!Objects.isNull(existingHotel)) {
			repo.delete(existingHotel);
		}
		return existingHotel;
	}
}
