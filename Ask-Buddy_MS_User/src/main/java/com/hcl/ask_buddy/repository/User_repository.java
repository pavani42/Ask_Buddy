package com.hcl.ask_buddy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.ask_buddy.entity.User_entity;



public interface User_repository extends JpaRepository<User_entity,Long>{
	@Query("select user from User_entity user where user.sap_Id = ?1 and user.password = ?2")
	public User_entity login(long userId, String password);
	
	public User_entity getByUsername(String username);
	
	public User_entity getByMail(String usermail);

}
