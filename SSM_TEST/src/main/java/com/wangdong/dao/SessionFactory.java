package com.wangdong.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.cj.Session;

public class SessionFactory {
	public static SqlSession getSession(){
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = ssf.openSession();
			return session;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
