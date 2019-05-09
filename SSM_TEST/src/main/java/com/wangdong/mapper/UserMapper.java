package com.wangdong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.wangdong.pojo.User;

public interface UserMapper {
	@Select("select * from user")
	List<User> selAll();
	
	@Insert("insert into user values(default,#{name},#{account})")
	void addUser(User user);
}
