package com.project.IotMiniSystem.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.IotMiniSystem.service.LocationService;
import com.project.IotMiniSystem.utilities.DeviceLogGenerator;
import com.project.IotMiniSystem.model.Location;

@CrossOrigin( "*")
@RestController
public class LocationController {

	@Autowired
	LocationService service;
	
	@GetMapping("/rooms")
	public ResponseEntity<List<Location>> getAllRooms() throws IOException {
		try {
		    return new ResponseEntity<>(service.getAllRooms(), HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	    
	}
	
	@PostMapping("/room")
	public ResponseEntity<Location> addRoom(@RequestBody Location room) throws IOException {
		try {
		    return new ResponseEntity<>(service.createRoom(room), HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	    
	}
	
	//get total number of rooms
	@GetMapping("/totalNoOfRooms")
	public long count() {
		return service.getTotalNumberOfRooms();
	}
}
