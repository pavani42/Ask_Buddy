package com.hcl.ask_buddy.answer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.answer.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findById(long id);

	public User getByMail(String username);
	

}
