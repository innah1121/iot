package com.project.IotMiniSystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.project.IotMiniSystem.Dto.DeviceDto;
import com.project.IotMiniSystem.exception.CustomException;
import com.project.IotMiniSystem.exception.ResourceNotFoundException;
import com.project.IotMiniSystem.model.Device;
import com.project.IotMiniSystem.repository.DeviceRepository;
import com.project.IotMiniSystem.repository.LocationRepository;
import com.project.IotMiniSystem.repositoryCustom.DeviceRepositoryCustom;
import com.project.IotMiniSystem.service.DeviceService;
import com.project.IotMiniSystem.model.Location;

@Service
public class DeviceServiceImplementation implements DeviceService {
	
	@Autowired
	DeviceRepository deviceRepo;
	
	@Autowired
	LocationRepository locRepo;
	
	@Autowired
	DeviceRepositoryCustom deviceRepoCustom;
	

	@Override
	public Device setupDevice(DeviceDto device) {
		
		Device deviceToSave = new Device();
		Location location = locRepo.findById(device.getLocationId()).get();
		deviceToSave.setLocation(location);
		deviceToSave.setName(device.getName());
		deviceToSave.setType(device.getType());
		deviceToSave.setState("OFF");
		deviceToSave.setMax_value(device.getMaxValue());
		deviceToSave.setMin_value(device.getMinValue());
		deviceToSave = deviceRepo.save(deviceToSave);
		return deviceToSave;
	}

	@Override
	public long getTotalNumberOfDevices() {
		
		return deviceRepoCustom.countDevices();
	}

	@Override
	public long getTotalNumberOfDevicesTurnedON() {
		
		return deviceRepoCustom.countONDevices();
	}

	@Override
	public Object getTotalPower() {
		
		return deviceRepoCustom.totalPower();
	}

	@Override
	public List<Device> getRoomDevices(String roomId) {
		
		return deviceRepoCustom.getRoomDevices(roomId);
	}

	@Override
	public List<Device> getAllDevices() {
		
		return deviceRepo.findAll();
	}

	@Override
	public Device updateDevice(Device device)  {
		
		Optional<Device> deviceData = deviceRepo.findById(device.getId());
        if (deviceData.isPresent()) {
        	Device deviceToUpdate = deviceData.get();
        	Location location = locRepo.findById(device.getLocation().getId()).get();
        	deviceToUpdate.setLocation(location);
        	deviceToUpdate.setName(device.getName());
        	deviceToUpdate.setType(device.getType());
        	deviceToUpdate.setState(device.getState());
        	deviceToUpdate.setMax_value(device.getMax_value());
        	deviceToUpdate.setMin_value(device.getMin_value());
        	deviceToUpdate = deviceRepo.save(deviceToUpdate);
        	return deviceToUpdate;
		 
        }
        else {
            throw new CustomException (
            	HttpStatus.NOT_FOUND.value() , "Device not found");
              }
        }
   
}
