package com.javaweb.Repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRoleEntity {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserEntity user= new UserEntity();
	
	@ManyToOne
	@JoinColumn(name="roleid")
	private RoleEntity role= new RoleEntity();
}
