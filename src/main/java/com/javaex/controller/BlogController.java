package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	//main
	@RequestMapping(value="/", method= {RequestMethod.GET, RequestMethod.POST})
	public String main(){
		System.out.println("/main");
		
		return "main/index";
	}
	
	//블로그 생성화면
	@RequestMapping(value="/{id}", method= {RequestMethod.GET, RequestMethod.POST})
	public String blogForm(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController]: blogForm");
		
		BlogVo blogVo = blogService.selectOne(id);
		
		if(blogVo != null) { //블로그 생성된 경우
			
			model.addAttribute("blogVo", blogVo);
			
			return "blog/blog-main";
			
		}else {              //아이디가 없을 경우
			
			return "error/403";
		}
	}
	
	//내블로그 관리 화면
	@RequestMapping(value="/{id}/admin/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public String adminForm(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController]: adminForm");
		
		BlogVo blogVo = blogService.selectOne(id);
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-basic";
	}
	
	//블로그 기본설정
	@RequestMapping(value="/upload", method= {RequestMethod.GET, RequestMethod.POST})
	public String adminBasic(@ModelAttribute BlogVo blogVo, @RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
		System.out.println("[BlogController]: adminBasic");
		
		blogService.modify(blogVo, file);
		
		return "redirect:/" + id + "/admin/basic";
	}
	
	//카테고리 관리폼
	@RequestMapping(value="/{id}/admin/category", method= {RequestMethod.GET, RequestMethod.POST})
	public String categoryForm(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController]: categoryForm");
		
		BlogVo blogVo = blogService.selectOne(id);
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-cate";
	}
	
	//글작성 폼
	@RequestMapping(value="/{id}/admin/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(@PathVariable("id") String id, Model model) {
		System.out.println("[BlogController]: writeForm");
		
		//블로그 헤더
		BlogVo blogVo = blogService.selectOne(id);
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-write";
	}
}
