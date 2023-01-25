package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PostException;
import com.masai.model.Post;
import com.masai.repository.PostRepo;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepo pr;
	
	
	
	@Override
	public List<Post> getAllPost() throws PostException {


		List<Post> allPost = pr.findAll();
		
		if(allPost.size()==0) {
			throw new PostException("No post found...!");
		}else {
			
			return allPost;
		}
		
	
	}

	@Override
	public Post getPost(Long id) throws PostException {
		
		
		Optional<Post> check=pr.findById(id);
		
		
		if(check.isPresent()) {
			return check.get();
		}else {
			throw new PostException("Invalid id...!");
		}

		
	}

	@Override
	public Post createPost(Post post) throws PostException {

     Optional<Post> check = pr.findById(post.getId());
     
     if(check.isEmpty()) {
    	 
    	 Post postedPost = pr.save(post);
    	 return postedPost;
     }else {
    	 throw new PostException("Post is already present ...!");
     }
		

	}

	@Override
	public Post updatePost(Post post,long id) throws PostException {


		  Optional<Post> check = pr.findById(id);
		     
		     if(check.isEmpty()) {
		    	 
		    	 throw new PostException("Invalid id ...!");
		     }else {

		      Post updatedPost= pr.save(post);
		      
		      return updatedPost;
		  
		     }	
		
	}

	@Override
	public Post deletePost(long id) throws PostException {
		
	
		  Optional<Post> check = pr.findById(id);
		     
		     if(check.isEmpty()) {
		    	 
		    	 throw new PostException("Invalid id ...!");
		     }else {


		      pr.delete(check.get());	 
		    	 
		    	return check.get(); 
		    	 
	 
		    	 
		     }	
		

	}

}
