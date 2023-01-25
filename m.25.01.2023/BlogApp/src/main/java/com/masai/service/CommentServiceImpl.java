package com.masai.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CommentException;
import com.masai.exception.PostException;
import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.repository.CommentRepo;
import com.masai.repository.PostRepo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo pr;
	@Autowired
	private CommentRepo cr;
	

	@Override
	public Set<Comment> getAllCommments(long postID) throws CommentException,PostException {

       Optional<Post> checkPost = pr.findById(postID);
       
       if(checkPost.isPresent()) {
    	   
    	   Set<Comment> allComments = checkPost.get().getComments();
    	   
    	   if(allComments.size()==0) {
    		   throw new CommentException("No comment found...!");
    	   }else {
    		   return allComments;
    	   }
    	   
    	   
       }else {
    	   
    	   throw new PostException("Invalid post id...!");
    	   
    	   
       }

		
	}

	@Override
	public Comment getComment(long postID, long commentID) throws CommentException,PostException {
		
		
	    Optional<Comment> checkComment = cr.findById(commentID);
	       
	       if(checkComment.isPresent()) {
	    	   
	    	if(postID==checkComment.get().getPost().getId()) {
	    		return checkComment.get();
	    	}else {
	    		throw new PostException("Invalid post id...!");
	    	}
	    	   
	    	   
	       }else {
	    	   
	    	   throw new CommentException("No comment found...!");
	    	   
	    	   
	       }
		
		

		
		
	}

	@Override
	public Comment createComment(long postId, Comment comment) throws CommentException,PostException {


	       Optional<Post> checkPost = pr.findById(postId);
	       
	       if(checkPost.isPresent()) {
	    	   
	    	 Post post = checkPost.get();
	    	 post.getComments().add(comment);
	    	 
	    	 pr.save(post);
	    	 
	    	 return comment;
	    	   
	    	   
	       }else {
	    	   
	    	   throw new PostException("Invalid post id...!");
	    	   
	    	   
	       }
		

		
	}

	@Override
	public Comment updateComment(long postID, long commentID,Comment comment) throws CommentException,PostException {
	
		
		  Optional<Comment> checkComment = cr.findById(commentID);
	       
	       if(checkComment.isPresent()) {
	    	   
	    	if(postID==checkComment.get().getPost().getId()) {


	    	Comment updateComment = checkComment.get();	
	    	updateComment.setBody(comment.getBody());
	    	
	    		
	    		return cr.save(updateComment);
	    		
	    		
	    		
	    	}else {
	    		throw new PostException("Invalid post id...!");
	    	}
	    	   
	    	   
	       }else {
	    	   
	    	   throw new CommentException("No comment found...!");
	    	   
	    	   
	       }	
		
		
		
	}

	@Override
	public Comment deleteComment(long postID, long commentID) throws CommentException,PostException {


		  Optional<Comment> checkComment = cr.findById(commentID);
	       
	       if(checkComment.isPresent()) {
	    	   
	    	if(postID==checkComment.get().getPost().getId()) {

              cr.delete(checkComment.get());
              return checkComment.get();
	    		
	    		
	    		
	    	}else {
	    		throw new PostException("Invalid post id...!");
	    	}
	    	   
	    	   
	       }else {
	    	   
	    	   throw new CommentException("No comment found...!");
	    	   
	    	   
	       }
		

		
		
	}

}
