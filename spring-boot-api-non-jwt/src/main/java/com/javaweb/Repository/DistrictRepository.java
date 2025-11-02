package com.javaweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.Repository.entity.DistrictEntity;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {
	
}
