package com.javaweb.Builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
	private String name;
	private Long floorArea;
	private String ward, street;
	private Long numberOfBasement;
	private String direction, level;
	private Long rentPriceFrom ;
	private Long rentPriceTo;
	private Long districtId;
	private Long areaFrom;
	private Long areaTo;
	private String mangerName,managerPhoneNumber;
	private Long staffId;
	private List<String> typeCode= new ArrayList<>();
	
	public BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.floorArea = builder.floorArea;
		this.ward = builder.ward;
		this.street = builder.street;
		this.numberOfBasement = builder.numberOfBasement;
		this.direction = builder.direction;
		this.level = builder.level;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
		this.districtId = builder.districtId;
		this.areaFrom = builder.areaFrom;
		this.areaTo = builder.areaTo;
		this.mangerName = builder.mangerName;
		this.managerPhoneNumber = builder.managerPhoneNumber;
		this.staffId = builder.staffId;
		this.typeCode = builder.typeCode;
	}
	public String getName() {
		return name;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public Long getNumberOfBasement() {
		return numberOfBasement;
	}
	public String getDirection() {
		return direction;
	}
	public String getLevel() {
		return level;
	}
	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}
	public Long getRentPriceTo() {
		return rentPriceTo;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public Long getAreaFrom() {
		return areaFrom;
	}
	public Long getAreaTo() {
		return areaTo;
	}
	public String getMangerName() {
		return mangerName;
	}
	public String getManagerPhone() {
		return managerPhoneNumber;
	}
	public Long getStaffId() {
		return staffId;
	}
	public List<String> getTypeCode() {
		return typeCode;
	}
	public static class Builder{
		private String name;
		private Long floorArea;
		private String ward, street;
		private Long numberOfBasement;
		private String direction, level;
		private Long rentPriceFrom ;
		private Long rentPriceTo;
		private Long districtId;
		private Long areaFrom;
		private Long areaTo;
		private String mangerName,managerPhoneNumber;
		private Long staffId;
		private List<String> typeCode= new ArrayList<>();
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setNumberOfBasement(Long numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}
		public Builder setDirection(String direction) {
			this.direction = direction;
			return this;
		}
		public Builder setLevel(String level) {
			this.level = level;
			return this;
		}
		public Builder setRentPriceFrom(Long rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}
		public Builder setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}
		public Builder setDistrictId(Long districtId) {
			this.districtId = districtId;
			return this;
		}
		public Builder setAreaFrom(Long areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}
		public Builder setAreaTo(Long areaTo) {
			this.areaTo = areaTo;
			return this;
		}
		public Builder setMangerName(String mangerName) {
			this.mangerName = mangerName;
			return this;
		}
		public Builder setManagerPhoneNumber(String managerphonenumber) {
			this.managerPhoneNumber = managerphonenumber;
			return this;
		}
		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		public Builder setTypeCode(List<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
	}
}
