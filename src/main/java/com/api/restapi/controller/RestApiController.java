package com.api.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.restapi.hotel.Hotel;
import com.api.restapi.hotel.HotelDTO;
import com.api.restapi.hotel.HotelService;

@SpringBootApplication
@RestController
public class RestApiController {

	@Autowired
	private HotelService hotelService;

	@GetMapping(value="/hotels")
	public ResponseEntity<List<Hotel>> getHotels() {
		List<Hotel> hotelList = hotelService.getAllHotels();
		if (hotelList.isEmpty()) {
			return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.OK);
	}

	@QueryMapping
	public List<Hotel> returnHotels() {
		List<Hotel> hotelList = hotelService.getAllHotels();
		return hotelList;
	}

	@QueryMapping
	public Hotel returnHotel(@Argument int hotelId) {
		Hotel hotel = hotelService.getHotel(hotelId);
		return hotel;
	}

	@MutationMapping
	public String addHotelDetails(@Argument HotelDTO hotelDTO) {
		if (hotelDTO != null && hotelDTO.getHotelAddress() != null && hotelDTO.getHotelName() != null
				&& hotelDTO.getHotelPinCode() > 0 && hotelDTO.getHotelRating() > 0) {
			hotelService.addHotel(hotelDTO);
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@MutationMapping
	public String updateHotelDetails(@Argument HotelDTO hotelDTO) {
		boolean updatedHotelDetails = hotelService.updateHotel(hotelDTO);
		if (updatedHotelDetails) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@QueryMapping
	public String deleteHotelDetails(@Argument int hotelId) {
		boolean deletedHotelDetails = hotelService.deleteHotel(hotelId);
		if (deletedHotelDetails) {
			return "SUCCESS";
		}
		return "FAILURE";
	}
}
