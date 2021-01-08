package com.project.IotMiniSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {
	  
	private int statusCode;
	private String message;
	  
}	  
	  

