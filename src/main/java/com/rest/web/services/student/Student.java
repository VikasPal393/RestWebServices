package com.rest.web.services.student;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int rollNo;
	
	@OneToMany(mappedBy = "student")
	private List<Post> postList;
	
	
	public Student() {
		super();
		
	}
	public Student(int id, String name, int rollNo) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	
	

}
