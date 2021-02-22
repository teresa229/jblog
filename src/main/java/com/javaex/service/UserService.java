package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	//회원가입
	public void join(UserVo userVo) {
		System.out.println("[UserService]: join");
		
		userDao.insert(userVo);
		System.out.println(userVo.getId());
		System.out.println(userVo.getUserName());
		
		//회원가입 insert 후 - blog insert
		String id = userVo.getId();
		String blogTitle = userVo.getUserName() + "의 블로그입니다.";
		
		//blogVo
		BlogVo blogVo = new BlogVo(id, blogTitle, null);
		blogDao.insert(blogVo);
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("[UserService]: login");
		
		return userDao.selectUser(userVo);
	}
	
	//아이디 체크
	public String checkId(String id) {
		System.out.println("[UserService]: checkId");
		
		UserVo userVo = userDao.selectOne(id);
		//System.out.println(userVo);
		
		String result = "";
		
		if(userVo == null) {
			result="can";
		}else {
			result="cant";
		}
		
		return result;
	}
}
