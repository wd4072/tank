package com.wangdong.service;

import java.util.List;
import com.wangdong.pojo.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	void addUser(User user);
}
