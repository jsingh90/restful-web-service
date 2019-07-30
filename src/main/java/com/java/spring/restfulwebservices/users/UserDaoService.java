package com.java.spring.restfulwebservices.users;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static int userCount = 4;
	
	static {
		users.add(new User(1, "Jasbeer", LocalDateTime.now() ));
		users.add(new User(2, "Pradeep", LocalDateTime.now()));
		users.add(new User(3, "Girijesh", LocalDateTime.now()));
		users.add(new User(4, "Rahul", LocalDateTime.now()));
		
	}
	
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		
		users.add(user);
		
		return user;
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> itr = users.iterator();
		
		User user = null;
		while(itr.hasNext()) {
			user = itr.next();
			if(user.getId() == id) {
				itr.remove();
				
				return user;
			}
		}
		
		return null;
	}
}
