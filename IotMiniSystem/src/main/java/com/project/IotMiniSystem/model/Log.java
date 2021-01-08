package com.project.IotMiniSystem.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Log {
	
	private String id;
	
	//@Field("name")
	private String actualValue;

	@DateTimeFormat(iso = ISO.DATE_TIME)
    private Date createdDate;
	
	//device

}
