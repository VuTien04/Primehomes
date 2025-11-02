package com.javaweb.Repository.Custom;

import java.util.List;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.Repository.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> findAll(BuildingSearchBuilder builder);
}
