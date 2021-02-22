package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	//회원가입 정보 저장
	public void insert(UserVo userVo) {
		System.out.println("[UserDao]: insert");
		System.out.println(userVo);
		
		sqlSession.insert("user.insert", userVo);
	}
	
	//로그인 위해 회원정보 조회
	public UserVo selectUser(UserVo userVo) {
		System.out.println("[UserDao]: selectUser");
		System.out.println(userVo);
		
		return sqlSession.selectOne("user.selectUser", userVo);
	}
	
	//아이디 체크 
	public UserVo selectOne(String id) {
		System.out.println("[UserDao]: selectOne");
		System.out.println(id);
		
		return sqlSession.selectOne("user.selectById", id);
	}
}
