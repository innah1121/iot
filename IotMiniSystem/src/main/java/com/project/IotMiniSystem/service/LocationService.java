package com.project.IotMiniSystem.service;

import java.util.List;
import com.project.IotMiniSystem.model.Device;
import com.project.IotMiniSystem.model.Location;

import org.springframework.stereotype.Service;

@Service
public interface LocationService {
	
	public List<Location> getAllRooms();
	
	public Location createRoom(Location room);
	
	public long getTotalNumberOfRooms();
	
	

}
