package com.javaweb.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.Repository.Custom.BuildingRepositoryCustom;
import com.javaweb.Repository.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>,BuildingRepositoryCustom {
	public List<BuildingEntity> findAll(BuildingSearchBuilder builder);
	List<BuildingEntity> findByNameContainingAndWardContaining(String name, String ward);
	void deleteByIdIn(List<Long> ids);
}
