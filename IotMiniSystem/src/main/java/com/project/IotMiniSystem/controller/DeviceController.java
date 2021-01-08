package com.project.IotMiniSystem.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.IotMiniSystem.Dto.DeviceDto;
import com.project.IotMiniSystem.model.Device;
import com.project.IotMiniSystem.repositoryCustom.DeviceRepositoryCustom;
import com.project.IotMiniSystem.service.DeviceService;
import com.project.IotMiniSystem.utilities.DeviceLogGenerator;

@CrossOrigin( "*")
@RestController
public class DeviceController {

	@Autowired
	DeviceService service;
	
	
	//get devices of a particular room
	@GetMapping("/allDevices")
	public ResponseEntity<List<Device>> getAllDevices() {
		return new ResponseEntity<>(service.getAllDevices(), HttpStatus.OK);
	}

	
	//set up device
	@PostMapping("/device")
	public ResponseEntity<Device> createDevice(@RequestBody DeviceDto device) throws IOException {
		try {
		    return new ResponseEntity<>(service.setupDevice(device), HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	//get devices of a particular room
	@GetMapping("/roomDevices")
	public ResponseEntity<List<Device>> findRoomDevices(@RequestParam String roomId) throws IOException {
		return new ResponseEntity<>(service.getRoomDevices(roomId), HttpStatus.OK);
	}
	
	//get total number of devices
	@GetMapping("/totalNoOfDevices")
	public long count() {
		return service.getTotalNumberOfDevices();
	}
	
	//get total number of devices turned ON
	@GetMapping("/totalNoOfDevicesON")
	public long countTurnedONDevices() {
		return service.getTotalNumberOfDevicesTurnedON();
	}
	
	//get actual power
	@GetMapping("/totalPower")
	public Object totalPower() {
		return service.getTotalPower();
	}
	
	//set up device
	@PutMapping("/device")
	public ResponseEntity<Device> update(@RequestBody Device device) {
	    return new ResponseEntity<>(service.updateDevice(device), HttpStatus.OK);
	}
	
	
}
