package com.project.IotMiniSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "locations")
public class Location {
	
	@Id
	private String id;
	
	private String name;
}
