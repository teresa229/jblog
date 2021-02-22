package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//블로그 테이블 정보 저장
	public void insert(BlogVo blogVo) {
		System.out.println("[BlogDao]: insert");
		
		sqlSession.insert("blog.insert", blogVo);
		
	}

	//블로그 조회
	public BlogVo selectOne(String id) {
		System.out.println("[BlogDao]: selectOne");
		
		return  sqlSession.selectOne("blog.selectOne", id);
	}
	
	//업데이트
	public void update(BlogVo blogVo) {
		System.out.println("[BlogDao]: update");
		System.out.println(blogVo);
		
		sqlSession.update("blog.update", blogVo);
	}
	
}
