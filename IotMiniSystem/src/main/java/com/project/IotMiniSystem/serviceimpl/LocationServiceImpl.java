package com.project.IotMiniSystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.IotMiniSystem.model.Device;
import com.project.IotMiniSystem.model.Location;
import com.project.IotMiniSystem.repository.LocationRepository;
import com.project.IotMiniSystem.repositoryCustom.LocationRepositoryCustom;
import com.project.IotMiniSystem.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository repo;
	
	@Autowired
	LocationRepositoryCustom repoCus;
	
	@Override
	public List<Location> getAllRooms() {
		List<Location> rooms = repo.findAll();
		return rooms;
	}

	@Override
	public Location createRoom(Location room) {
		// TODO Auto-generated method stub
		return repo.save(room);
	}

	@Override
	public long getTotalNumberOfRooms() {
		// TODO Auto-generated method stub
		return repoCus.totalRooms();
	}

}
