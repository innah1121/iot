package com.project.IotMiniSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "devices")
public class Device {
	
	
	  @Id
	  private String id;
	  
	  @Indexed(unique = true)
	  private String name;

	  private String type;
	  
	  @DBRef
	  private Location location;
	  
	  private String state;
	  
	  private int min_value;
	  
	  private int max_value;

	 

}
