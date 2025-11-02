package com.javaweb.Service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.Converters.BuildingConverter;
import com.javaweb.Converters.BuildingSearchBuilderConverter;
import com.javaweb.Repository.BuildingRepository;
import com.javaweb.Repository.DistrictRepository;
import com.javaweb.Repository.RentAreaRepository;
import com.javaweb.Repository.entity.BuildingEntity;
import com.javaweb.Repository.entity.DistrictEntity;
import com.javaweb.Repository.entity.RentAreaEntity;
import com.javaweb.Service.BuildingService;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.response.BuildingResponseDTO;

@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	@Override
	public List<BuildingResponseDTO> findAll(Map<String, Object> map,List<String> typeCode) {
		BuildingSearchBuilder builder= buildingSearchBuilderConverter.toBuildingSearchBuilder(map, typeCode);
		List<BuildingEntity> buildingEntities= buildingRepository.findAll(builder);
		List<BuildingResponseDTO> result= new ArrayList<>();
		for(BuildingEntity it : buildingEntities) {
			BuildingResponseDTO buildingResponseDTO = buildingConverter.toBuidlingResponseDTO(it); 
			result.add(buildingResponseDTO);
		}
		return result;
	}
	
	@Override
	public BuildingEntity createOrUpdateBuilding(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity= buildingConverter.toBuildingEntity(buildingDTO);
		DistrictEntity districtEntity=districtRepository.findById(buildingDTO.getDistrictId()).get();
		buildingEntity.setDistrict(districtEntity);
//		buildingEntity.setRentareas(areaEntities);
		buildingRepository.save(buildingEntity);
		
		if(buildingEntity.getId() != null) {
			rentAreaRepository.deleteByBuildingEntity(buildingEntity);
		}
		List<RentAreaEntity> areaEntities= new ArrayList<>();
		RentAreaEntity areaEntity1=new RentAreaEntity();
		areaEntity1.setBuildingEntity(buildingEntity);
		areaEntity1.setValue(300L);
		RentAreaEntity areaEntity2=new RentAreaEntity();
		areaEntity2.setBuildingEntity(buildingEntity);
		areaEntity2.setValue(400L);
		areaEntities.add(areaEntity1);
		areaEntities.add(areaEntity2);
		rentAreaRepository.saveAll(areaEntities);
		return null;
	}
	
	@Override
	public void deleteById(List<Long> ids) {
		rentAreaRepository.deleteByBuildingEntity_IdIn(ids);
		buildingRepository.deleteByIdIn(ids);
	}

}
