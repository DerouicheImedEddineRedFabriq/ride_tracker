package com.pluralsight.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.dto.RideDto;
import com.pluralsight.model.Ride;
import com.pluralsight.service.RideService;

@Controller
public class RideController {

	private static DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Autowired
	private RideService rideService;
	
	@RequestMapping(value = "/rides", method = RequestMethod.POST)
	public @ResponseBody Ride createRide(@Validated @RequestBody RideDto rideDto)
	{
		Ride ride = mapper.map(rideDto, Ride.class);
		ride = rideService.createRide(ride);
		
		return ride;
	}
	
	@RequestMapping(value = "/rides", method = RequestMethod.GET)
	public @ResponseBody List<Ride> getRides() {
		return rideService.getRides();
	}
	
}
