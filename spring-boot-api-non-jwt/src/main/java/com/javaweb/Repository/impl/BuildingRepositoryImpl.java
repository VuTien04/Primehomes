package com.javaweb.Repository.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.Repository.BuildingRepository;
import com.javaweb.Repository.entity.BuildingEntity;
import com.javaweb.Utils.DataUtil;
import com.javaweb.Repository.Custom.*;
@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void joinSQL(BuildingSearchBuilder builder,StringBuilder sql) {
		Long areaTo=builder.getAreaTo();
		Long areaFrom=builder.getAreaFrom();
		if(DataUtil.check(areaFrom) || DataUtil.check(areaTo)) {
			sql.append(" inner join rentarea ra on ra.buildingid=b.id");
		}
		List<String> typeCode=builder.getTypeCode();
		if(typeCode!=null && typeCode.size()!=0) {
			sql.append(" inner join buildingrenttype brt on brt.buildingid=b.id"
					+ " inner join renttype rt on brt.renttypeid=rt.id ");
		}
		Long staffId= builder.getStaffId();
		if(DataUtil.check(staffId)) {
			sql.append(" inner join assignmentbuilding asb on asb.buildingid=b.id");
		}
	}
	public void whereNormal(BuildingSearchBuilder builder,StringBuilder where) {
		try {
			Field[] fileds= BuildingSearchBuilder.class.getDeclaredFields();
			for(Field it:fileds) {
				it.setAccessible(true);
				String fieldName = it.getName();
				if(!fieldName.startsWith("area") && !fieldName.startsWith("rentPrice") 
						&& !fieldName.equals("staffId") && !fieldName.equals("typeCode")) {
					Object value=it.get(builder);
					if(value!=null) {
						if(it.getType().getName().equals("java.lang.Long")) {
							where.append(" AND b."+fieldName+"="+value);
						}else if(it.getType().getName().equals("java.lang.String")) {
							where.append(" AND b."+fieldName+" LIKE '%"+value+"%'");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void whereSpecial(BuildingSearchBuilder builder,StringBuilder where) {
		Long areaTo=builder.getAreaTo();
		Long areaFrom=builder.getAreaFrom();
		if(DataUtil.check(areaFrom)) {
			where.append(" AND value >="+areaFrom);
		}
		if(DataUtil.check(areaTo)) {
			where.append(" AND value <="+areaTo);
		}
		Long rentPriceFrom=builder.getRentPriceFrom();
		Long rentPriceTo=builder.getRentPriceTo();
		if(DataUtil.check(rentPriceFrom)) {
			where.append(" AND b.rentprice >="+rentPriceFrom);
		}
		if(DataUtil.check(rentPriceTo)) {
			where.append(" AND b.rentprice <="+rentPriceTo);
		}
		List<String> typeCode=builder.getTypeCode();
		if(typeCode!=null && typeCode.size()!=0) {
			where.append(" AND rt.code IN("+typeCode.stream().map(i->"'"+i+"'").collect(Collectors.joining(","))+")");
		}
		Long staffId=builder.getStaffId();
		if(DataUtil.check(staffId)) {
			where.append(" AND staffId="+staffId);
		}
	}
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder builder) {
		StringBuilder sql=new StringBuilder("Select b.* FROM building b");
		StringBuilder where= new StringBuilder(" Where 1=1");
		joinSQL(builder, sql);
		whereNormal(builder, where);
		whereSpecial(builder, where);
		sql.append(where).append(" GROUP BY (b.id)");
		Query query= entityManager.createNativeQuery(sql.toString(),BuildingEntity.class);
		return query.getResultList();
	}

}
