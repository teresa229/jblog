package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	//조회하기
	public BlogVo selectOne(String id) {
		System.out.println("[BlogService]: selectOne");
		
		return blogDao.selectOne(id);
	}
	
	//프로필 수정
	public void modify(BlogVo blogVo, MultipartFile file) {
		System.out.println("[BlogService]: modify");
		
		blogDao.update(blogVo);
	}
}
