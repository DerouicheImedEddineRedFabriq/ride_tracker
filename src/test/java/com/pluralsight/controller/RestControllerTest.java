package com.pluralsight.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pluralsight.dto.RideDto;
import com.pluralsight.model.Ride;

public class RestControllerTest {

	@Test(timeout=30000)
	public void testCreateRide()
	{
		RestTemplate restTemplate = new RestTemplate();
		
		RideDto rideDto = new RideDto();
		rideDto.setName("Imed's ride 2");
		rideDto.setDuration(40);
		
		HttpEntity<RideDto> request = new HttpEntity<>(rideDto);
		
		ResponseEntity<Ride> ridesResponse = restTemplate.postForEntity("http://localhost:8080/ride_tracker/rides", request, Ride.class);
		
		System.out.println("Ride name: " + ridesResponse.getBody().getName());
	}
	
	@Test(timeout=3000)
	public void testGetRides() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Ride>> ridesResponse = restTemplate.exchange(
				"http://localhost:8080/ride_tracker/rides", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Ride>>() {
				});
		List<Ride> rides = ridesResponse.getBody();

		for (Ride ride : rides) {
			System.out.println("Ride id: " + ride.getId());
			System.out.println("Ride name: " + ride.getName());
		}
	}
}
