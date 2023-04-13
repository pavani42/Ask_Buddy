package com.hcl.ask_buddy.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ask_buddy.question.entity.Likes;

@Repository
public interface LikesRepo extends JpaRepository<Likes, Double>{

}
