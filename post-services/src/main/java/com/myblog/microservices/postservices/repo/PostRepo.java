package com.myblog.microservices.postservices.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myblog.microservices.postservices.model.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

	public List<Post> findByUserName(String userName);
	
	@Query(value="SELECT p from Post p WHERE p.isPrivate=FALSE")
	public List<Post> getAllPublicPost();
	
	@Query(value="SELECT p from Post p WHERE p.isPrivate=FALSE AND p.id=:id")
	public Post getPublicPostById(@Param("id") Long id);
}
