package com.masai.service;

import java.util.List;

import com.masai.exception.PostException;
import com.masai.model.Post;



public interface PostService {

	
	
	public List<Post> getAllPost() throws PostException;
	
	public Post getPost(Long id) throws PostException;
	
	public Post createPost(Post post) throws PostException;
	
	public Post updatePost(Post post,long id) throws PostException;
	
	public Post deletePost(long id) throws PostException;
	
	
	
	
	
	
	
	
	
	
	
	
}
