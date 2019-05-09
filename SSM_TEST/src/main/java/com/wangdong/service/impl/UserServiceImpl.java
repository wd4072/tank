package com.wangdong.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangdong.dao.SessionFactory;
import com.wangdong.mapper.UserMapper;
import com.wangdong.pojo.User;
import com.wangdong.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public List<User> getAllUsers() {
		//SqlSession session = SessionFactory.getSession();
		//UserMapper userMapper = session.getMapper(UserMapper.class);
		return	userMapper.selAll();
	}
	

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public void addUser(User user) {
		userMapper.addUser(user);		
	}

}
