package com.project.IotMiniSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.IotMiniSystem.model.Device;
import com.project.IotMiniSystem.model.Location;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {

}

