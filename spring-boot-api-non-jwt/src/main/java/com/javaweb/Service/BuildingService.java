package com.javaweb.Service;

import java.util.List;
import java.util.Map;

import com.javaweb.Repository.entity.BuildingEntity;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.response.BuildingResponseDTO;

public interface BuildingService {
	 List<BuildingResponseDTO> findAll(Map<String, Object> map,List<String> typeCode); 
	 BuildingEntity createOrUpdateBuilding(BuildingDTO buildingDTO);
	 void  deleteById(List<Long> ids);
}
