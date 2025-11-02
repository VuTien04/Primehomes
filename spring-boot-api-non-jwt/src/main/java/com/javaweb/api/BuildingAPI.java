package com.javaweb.api;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.CustomExceptions.InvalidDataException;
import com.javaweb.Repository.BuildingRepository;
import com.javaweb.Repository.entity.BuildingEntity;
import com.javaweb.Service.BuildingService;
import com.javaweb.dto.*;
import com.javaweb.dto.response.BuildingResponseDTO;

@RestController
@PropertySource("classpath:application.properties")
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	
	@Value("${dev.tien}")
	private String tmp;
	@GetMapping("/api/building")
	private Object getBuildings(@RequestParam Map<String,Object> map,
								@RequestParam(name="typeCode", required = false) List<String> typeCode) {
//		System.out.println(tmp);
		List<BuildingResponseDTO> buildingResponseDTOs= buildingService.findAll(map,typeCode);
		return buildingResponseDTOs;
	}
	
	private void validate(BuildingDTO building){
		if(building.getName() == null || building.getNumberOfBasement() ==null) 
			throw new InvalidDataException("Name or NumberOfBasement not NULL.");
		else if(building.getName().equals("")) throw new InvalidDataException("Ten dang rong");
	}
	
	@PostMapping("/api/buildings")
	private Object createBuilding(@RequestBody BuildingDTO building) {
		validate(building);
		return buildingService.createOrUpdateBuilding(building);
	}
	

	@DeleteMapping("/api/buildings/{ids}")
	private void deleteBuilding(@PathVariable List<Long> ids) {
		if(ids.size()!=0) {
			buildingService.deleteById(ids);
		}
	}
}