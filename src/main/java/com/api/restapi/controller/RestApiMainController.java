package com.api.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.api.restapi.hotel.Hotel;
import com.api.restapi.hotel.HotelDTO;
import com.api.restapi.hotel.HotelService;
import com.google.gson.Gson;

@SpringBootApplication
@RequestMapping("/")
@Controller
public class RestApiMainController {

	@Autowired
	private HotelService hotelService;

	@GetMapping("/*")
	public String getHome() {
		return "home.jsp";
	}
	
	@PostMapping("/*")
	public String postHome() {
		return "home.jsp";
	}

	@GetMapping(value = "view*", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView returnHotel(@RequestParam("hotelIdToSearch") String s) {
		ModelAndView mv = new ModelAndView("/");
		if(s.isEmpty()) {
			mv.addObject("message", "FAILURE");
			return mv;
		}
		int id = Integer.parseInt(s);
		Hotel hotel = null;
		List<Hotel> hotelList = null;
		if(id > 0) {
			hotel = hotelService.getHotel(id);
			if (hotel == null) {
				mv.addObject("message", null);
			}else {
				mv.addObject("message", new Gson().toJson(hotel));
			}
		} else {
			hotelList = hotelService.getAllHotels();
			mv.addObject("message", new Gson().toJson(hotelList));
		}
		return mv;
	}

	@PostMapping("add")
	public ModelAndView addHotelDetails(@RequestParam("hotelName") String hotelName, @RequestParam("hotelAddress") String hotelAddress, @RequestParam("hotelPinCode") String hotelPinCode, @RequestParam("hotelRating") String hotelRating) {
		ModelAndView mv = new ModelAndView("/web");
		if(hotelRating.isEmpty() || hotelPinCode.isEmpty()) {
			mv.addObject("message", "FAILURE");
			return mv;
		}
		HotelDTO hotel = new HotelDTO(hotelName, Float.parseFloat(hotelRating), hotelAddress, Integer.parseInt(hotelPinCode));
		if (hotel != null && hotel.getHotelAddress() != null && hotel.getHotelName() != null
				&& hotel.getHotelPinCode() > 0 && hotel.getHotelRating() > 0) {
			hotelService.addHotel(hotel);
			mv.addObject("message", "SUCCESS");
		} else {
			mv.addObject("message", "FAILURE");
		}
		return mv;
	}

	@PostMapping("update")
	public ModelAndView updateHotelDetails(@RequestParam("hotelId") String hotelId, @RequestParam("hotelName") String hotelName, @RequestParam("hotelAddress") String hotelAddress, @RequestParam("hotelPinCode") String hotelPinCode, @RequestParam("hotelRating") String hotelRating) {
		ModelAndView mv = new ModelAndView("/web");
		if(hotelId.isEmpty()) {
			mv.addObject("message", "FAILURE");
			return mv;
		}
		int id = Integer.parseInt(hotelId);
		boolean updatedHotelDetails = hotelService.updateHotelUsingForm(id, hotelName, hotelRating, hotelAddress, hotelPinCode);
		if (updatedHotelDetails) {
			mv.addObject("message", "SUCCESS");
		} else {
			mv.addObject("message", "FAILURE");
		}
		return mv;
	}

	@GetMapping("delete*")
	public ModelAndView deleteHotelDetails(@RequestParam("hotelIdToSearch") String s) {
		ModelAndView mv = new ModelAndView("/web");
		if(s.isEmpty()) {
			mv.addObject("message", "FAILURE");
			return mv;
		}
		int id = Integer.parseInt(s);
		boolean deletedHotelDetails = hotelService.deleteHotel(id);
		if (deletedHotelDetails) {
			mv.addObject("message", "SUCCESS");
		} else {
			mv.addObject("message", "FAILURE");
		}
		return mv;
	}
}
