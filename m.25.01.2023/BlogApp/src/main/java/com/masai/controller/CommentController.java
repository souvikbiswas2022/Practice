package com.masai.controller;

import java.util.Set;

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
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CommentException;
import com.masai.exception.PostException;
import com.masai.model.Comment;
import com.masai.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService cs;
	
	
	@GetMapping("/posts/{postid}/comments")
	public ResponseEntity<Set<Comment>> getAllCommments(@PathVariable("postid")  long postID) throws CommentException,PostException{	
		
		return new ResponseEntity<Set<Comment>>(cs.getAllCommments(postID),HttpStatus.OK);
		

	}
	
	
	@GetMapping("/posts/{postid}/comments/{id}")
	public ResponseEntity<Comment> getComment(@PathVariable("postid") long postID ,@PathVariable("id") long commentID) throws CommentException,PostException{
		
		
		return new ResponseEntity<Comment>(cs.getComment(postID, commentID),HttpStatus.OK);	
			
	}

	
	@PostMapping("/posts/{postid}/comments")
	public ResponseEntity<Comment> createComment(@PathVariable("postid") long postId,@RequestBody Comment comment) throws CommentException,PostException{
		
		return new ResponseEntity<Comment>(cs.createComment(postId, comment),HttpStatus.CREATED);	
		
	}
	
	
	@PutMapping("/posts/{postid}/comments/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable("postid") long postID ,@PathVariable("id") long commentID,@RequestBody  Comment comment) throws CommentException,PostException{
		
		
		return new ResponseEntity<Comment>(cs.updateComment(postID, commentID, comment),HttpStatus.OK);	
			
		
	}
	
	
	@DeleteMapping("/posts/{postid}/comments/{id}")
	public ResponseEntity<Comment> deleteComment(@PathVariable("postid") long postID ,@PathVariable("id") long commentID) throws CommentException,PostException{
		
		
		return new ResponseEntity<Comment>(cs.deleteComment(postID, commentID),HttpStatus.OK);	
		

		
	}
	
	
	
	/*
	 * 
	
	
		
		
    
    
    
    
    
	
	
    
	 */
	
	
	
	
	
}
