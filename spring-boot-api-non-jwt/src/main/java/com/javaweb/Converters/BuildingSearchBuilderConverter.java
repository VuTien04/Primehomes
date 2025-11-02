package com.javaweb.Converters;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.Utils.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> map,List<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
													  .setName(MapUtil.getObject(map, "name", String.class))
													  .setFloorArea(MapUtil.getObject(map, "floorArea", Long.class))
													  .setDistrictId(MapUtil.getObject(map, "districtId", Long.class))
													  .setWard(MapUtil.getObject(map, "ward", String.class))
													  .setStreet(MapUtil.getObject(map, "street", String.class))
													  .setNumberOfBasement(MapUtil.getObject(map, "numberOfBasement", Long.class))
													  .setDirection(MapUtil.getObject(map, "direction", String.class))
													  .setLevel(MapUtil.getObject(map, "direction", String.class))
													  .setAreaFrom(MapUtil.getObject(map, "areaFrom", Long.class))
													  .setAreaTo(MapUtil.getObject(map, "areaTo", Long.class))
													  .setRentPriceFrom(MapUtil.getObject(map, "rentPriceFrom", Long.class))
													  .setRentPriceTo(MapUtil.getObject(map, "rentPriceTo", Long.class))
													  .setMangerName(MapUtil.getObject(map, "managerName", String.class))
													  .setManagerPhoneNumber(MapUtil.getObject(map, "managerPhone", String.class))
													  .setStaffId(MapUtil.getObject(map, "staffId", Long.class))
													  .setTypeCode(typeCode)
													  .build();
		return buildingSearchBuilder;
	}
}
