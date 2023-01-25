package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 private String body;
	
	 
	@JsonIgnore
	 @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 private Post post;
	
	
	

	
}