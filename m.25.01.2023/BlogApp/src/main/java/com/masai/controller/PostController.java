package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.masai.exception.PostException;
import com.masai.model.Post;
import com.masai.service.PostService;

@RestControllerAdvice
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService ps;
	
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPost() throws PostException{
		
	return new ResponseEntity<List<Post>>(ps.getAllPost(),HttpStatus.OK);	
			
	}
	
	
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPost(@PathVariable("id") Long id) throws PostException{
		
		return new ResponseEntity<Post>(ps.getPost(id),HttpStatus.OK);
		
	}
	
	
	@PostMapping("/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post post) throws PostException{
		
		return new ResponseEntity<Post>(ps.createPost(post),HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("posts/{id}")
	public ResponseEntity<Post> updatePost(@RequestBody Post post,@PathVariable("id") long id) throws PostException{
		
		return new ResponseEntity<Post>(ps.updatePost(post, id),HttpStatus.OK);	

	}
	
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable("id") long id) throws PostException{
		
		return new ResponseEntity<Post>(ps.deletePost(id),HttpStatus.OK);	
		

		
	}
	

	
}
