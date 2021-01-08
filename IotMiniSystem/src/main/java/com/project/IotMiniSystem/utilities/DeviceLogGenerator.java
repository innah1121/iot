package com.project.IotMiniSystem.utilities;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.project.IotMiniSystem.repositoryCustom.DeviceRepositoryCustom;


@Component
public class DeviceLogGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(DeviceLogGenerator.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

	@Autowired
	private DeviceRepositoryCustom deviceRepo;
	
	//cron = (second, minute, hour, day of month, month, day(s) of week)
	//@Scheduled (cron = "0 13 18  * * *")     <-- this is good
	
	@Scheduled (cron = "0 45 15  * * *")  
	public boolean reportPowerConsumption() {

		int actualPower = (int) deviceRepo.totalPower();
		System.out.println("he praa" + actualPower);
		
		if(actualPower >= 1000) {
			System.out.println("he praa true" + actualPower);
			return true;
		}
		else {
			return false;
		}
	}
//	public void generateJson() throws IOException {
//		  
//		  JsonFactory factory = new JsonFactory();
//	      StringWriter jsonObjectWriter = new StringWriter();
//	      JsonGenerator generator = factory.createGenerator(jsonObjectWriter);
//	      generator.useDefaultPrettyPrinter(); // pretty print JSON
//	      generator.writeStartObject();
//	      
//	      generator.writeFieldName("firstName");
//	      generator.writeString("Ravi");
//	      
//	      generator.writeFieldName("lastName");
//	      generator.writeString("Chandra");
//	      
//	      generator.writeFieldName("technologies");
//	      generator.writeStartArray();
//	      generator.writeString("SAP");
//	      generator.writeString("Java");
//	      generator.writeString("Selenium");
//	      generator.writeEndArray();
//	      
//	      generator.writeEndObject();
//	      generator.close(); // to close the generator
//	      System.out.println(jsonObjectWriter.toString());
//	}
//	
	

}
