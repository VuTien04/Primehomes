package com.javaweb.Repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//	private List<UserRoleEntity> userRoleEntities=new ArrayList<>();
	
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users= new ArrayList<>();
}
