package com.project.IotMiniSystem.service;

import java.util.List;

import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;

import com.project.IotMiniSystem.Dto.DeviceDto;
import com.project.IotMiniSystem.model.Device;

@Service
public interface DeviceService {
	
	public Device setupDevice(DeviceDto device);
	
    public long getTotalNumberOfDevices();
    
    public long getTotalNumberOfDevicesTurnedON();
    
    public Object getTotalPower();
    
    public List<Device> getRoomDevices(String roomId);
    
    public List<Device> getAllDevices();
    
    public Device updateDevice(Device device);

}
