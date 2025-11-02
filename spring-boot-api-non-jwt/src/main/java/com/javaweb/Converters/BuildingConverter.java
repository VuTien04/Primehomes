package com.javaweb.Converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.Repository.entity.BuildingEntity;
import com.javaweb.Repository.entity.DistrictEntity;
import com.javaweb.Repository.entity.RentAreaEntity;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.response.BuildingResponseDTO;

@Component
public class BuildingConverter {
	@Autowired
	private ModelMapper modelMapper;
	public BuildingResponseDTO toBuidlingResponseDTO(BuildingEntity it) {
		BuildingResponseDTO buildingResponseDTO = modelMapper.map(it, BuildingResponseDTO.class) ;
		DistrictEntity districtEntity= it.getDistrict();
		buildingResponseDTO.setAddress(it.getStreet()+","+it.getWard()+","+districtEntity.getName());
		List<RentAreaEntity> areaEntities= it.getRentareas();
		String rentArea=areaEntities.stream().map(i->i.getValue().toString()).collect(Collectors.joining(","));
		buildingResponseDTO.setValue(rentArea);
		return buildingResponseDTO;
	}
	
	public BuildingEntity toBuildingEntity(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity=modelMapper.map(buildingDTO, BuildingEntity.class);
		return buildingEntity;
	}
}
