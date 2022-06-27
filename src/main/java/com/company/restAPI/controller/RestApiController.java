package com.company.restAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.restAPI.hotel.Hotel;
import com.company.restAPI.hotel.HotelDTO;
import com.company.restAPI.hotel.HotelService;
import com.google.gson.Gson;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	private HotelService hotelService;

	@GetMapping
	public ResponseEntity<List<Hotel>> returnHotels() {
		List<Hotel> hotelList = hotelService.getAllHotels();
		if (hotelList.isEmpty()) {
			return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> returnHotel(@PathVariable int id) {
		Hotel hotel = hotelService.getHotel(id);
		if (hotel == null) {
			return new ResponseEntity<String>("{}", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>(new Gson().toJson(hotel), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> addHotelDetails(@RequestBody HotelDTO hotelDTO) {
		if (hotelDTO != null && hotelDTO.getHotelAddress() != null && hotelDTO.getHotelName() != null
				&& hotelDTO.getHotelPinCode() > 0 && hotelDTO.getHotelRating() > 0) {
			hotelService.addHotel(hotelDTO);
			return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("FAILURE", HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public ResponseEntity<String> updateHotelDetails(@RequestBody HotelDTO hotelDTO) {
		boolean updatedHotelDetails = hotelService.updateHotel(hotelDTO);
		if (updatedHotelDetails) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("FAILURE", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHotelDetails(@PathVariable int id) {
		boolean deletedHotelDetails = hotelService.deleteHotel(id);
		if (deletedHotelDetails) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAILURE", HttpStatus.BAD_REQUEST);
	}
}
