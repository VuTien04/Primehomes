package com.javaweb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.Repository.entity.BuildingEntity;
import com.javaweb.Repository.entity.RentAreaEntity;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {
	void deleteByBuildingEntity(BuildingEntity buildingEntity);
	void deleteByBuildingEntity_IdIn(List<Long> BuildingIds);
}
