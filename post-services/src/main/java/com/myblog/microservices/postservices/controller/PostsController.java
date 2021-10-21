package com.myblog.microservices.postservices.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.microservices.postservices.model.Post;
import com.myblog.microservices.postservices.response.ResponseHandler;
import com.myblog.microservices.postservices.service.PostService;

@RestController
public class PostsController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	Environment env;
	

	@GetMapping("/posts")
	public ResponseEntity<Object> getAllPostsOfUser(@RequestHeader(value="id") String username) {
		try {
			String port = env.getProperty("local.server.port");
			System.out.println("POST PORT: "+port);
			List<Post> resultPost =postService.getAllPostForUser(username);
			return ResponseHandler.generateResponse("Success.", HttpStatus.OK, resultPost);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<Object> getPostByIdForUser( @PathVariable Long postId) {
		try {
			Post resultPost = postService.getPostById(postId);
			return ResponseHandler.generateResponse("Success.", HttpStatus.ACCEPTED, resultPost);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
	
	@GetMapping("/posts/public")
	public ResponseEntity<Object> getAllPublicPost() {
		try {
			List<Post> resultPost = postService.getAllPublicPost();
			return ResponseHandler.generateResponse("Success.", HttpStatus.OK, resultPost);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
	
	@GetMapping("/posts/{postId}/public")
	public ResponseEntity<Object> getPublicPostById(@PathVariable Long postId) {
		try {
			Post resultPost = postService.getPublicPostById(postId);
			if(resultPost!=null)
				return ResponseHandler.generateResponse("Success.", HttpStatus.ACCEPTED, resultPost);
			else
				return ResponseHandler.generateResponse("No Posts Present with ID: "+postId, HttpStatus.ACCEPTED, resultPost);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
	
	// REST for creating new posts
	
	@PostMapping("/posts")
	public ResponseEntity<Object> createNewPost(@RequestHeader(value="id") String username, @RequestBody Post post) {
		post.setUserName(username);
		try {
			Post result = postService.createNewPost(post);
			return ResponseHandler.generateResponse("Successfully Created the Post.", HttpStatus.CREATED, result);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
		
	}
	
	//REST for deleting the post
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<Object> deletePost(@RequestHeader(value="id") String username, @PathVariable Long postId) {
		try {
			boolean result = postService.deletePost(postId);
			if(result==true)
				return ResponseHandler.generateResponse("Successfully Deleted the Post.", HttpStatus.ACCEPTED, null);
			else
				return ResponseHandler.generateResponse("Error deleting the post. Post not present with the ID: "+postId, HttpStatus.ACCEPTED, null);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
		
	}
	
	// REST for editing the Post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<Object> updatePost(@RequestHeader(value="id") String username, @RequestBody Post post, @PathVariable Long postId) {
		try {
			Post updatedPost = postService.updatePost(postId,post);
			if(updatedPost!=null)
				return ResponseHandler.generateResponse("Successfully Updated the Post.", HttpStatus.ACCEPTED, updatedPost);
			else
				return ResponseHandler.generateResponse("Error updating the post. Post not present with the ID: "+postId, HttpStatus.ACCEPTED, null);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
		
	}
	 
	
	
	

}
