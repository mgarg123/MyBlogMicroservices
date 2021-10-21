package com.myblog.microservices.postservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.microservices.postservices.model.Post;
import com.myblog.microservices.postservices.repo.PostRepo;

@Service
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	public Post getPostById(Long id) {
		return postRepo.findById(id).get();
	}
	
	public List<Post> getAllPostForUser(String userName){
		return postRepo.findByUserName(userName);
	}
	
	public List<Post> getAllPublicPost(){
		return postRepo.getAllPublicPost();
	}

	public Post getPublicPostById(Long postId) {
		return postRepo.getPublicPostById(postId);
	}
	
	// Create post
	
	public Post createNewPost(Post post) {
		postRepo.save(post);
		return post;
	}

	public boolean deletePost(Long id) {
		try {
			postRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public Post updatePost(Long postId, Post post) {
		Post updatedPost = getPostById(postId);
		updatedPost.setTitle(post.getTitle());
		updatedPost.setContent(post.getContent());
		postRepo.save(updatedPost);
		return updatedPost;
	}

}
