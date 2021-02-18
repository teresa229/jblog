package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class jblog {

	@RequestMapping( "/jblog")
	public String hello(){
		System.out.println("/jblog/controller");
		return "/WEB-INF/views/index.jsp";
	}
}
