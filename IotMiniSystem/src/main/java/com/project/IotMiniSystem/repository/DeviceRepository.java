package com.project.IotMiniSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.IotMiniSystem.model.Device;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {

	
}
