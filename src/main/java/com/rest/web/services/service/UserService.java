package com.rest.web.services.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.web.services.dao.User;
import com.rest.web.services.exception.UserNotFoundException;


@Component
public class UserService {
	
	public static List<User> users = new ArrayList<User>();
	
	static {
		
		users.add(new User(1,"vikas"));
		users.add(new User(2,"vik"));
		users.add(new User(3,"vi"));
		
	}
	
	private int userCount = 3;
	
	public List<User> allUsers(){
		
		return users;
		
	}
		
	public User findOne(int id)
	{
		for(User i : users)
		if(i.getId()==id) {
			return i;
		}
		
		return null;
		
	
	}
	
	public void save(User user)
	{
		user.setId(++userCount);
		users.add(user);
	}
	
	public void  delete(int id)
	{
		for(User i : users)
			if(i.getId()==id)
			{
				users.remove(i);
				break;
			}
			else
				throw new UserNotFoundException("id-"+id);
		
		
	
	}
		
	}

