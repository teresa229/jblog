package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	//회원가입
	public void join(UserVo userVo) {
		System.out.println("[UserService]: join");
		
		userDao.insert(userVo);
		System.out.println(userVo.getId());
		System.out.println(userVo.getUserName());
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("[UserService]: login");
		
		return userDao.selectUser(userVo);
	}
	
}
