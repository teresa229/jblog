package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	//회원가입 폼
	@RequestMapping(value="/joinForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("[UserController]: joinForm");
		
		return "user/joinForm";
	}

	//회원가입
	@RequestMapping(value="/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("[UserController]: join");
		
		userService.join(userVo);
		
		return "user/joinSuccess";
	}
	
	//로그인폼
	@RequestMapping(value="/loginForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("[UserController]: loginForm");
		
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("[UserController]: login");
		
		UserVo authUser = userService.login(userVo);

		if(authUser!= null) { //성공
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/";
			
		}else {              //실패
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	//로그아웃
	@RequestMapping(value="/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("[UserController]: logout");
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	//회원 가입 아이디 체크
	@ResponseBody
	@RequestMapping(value="/checkid", method= {RequestMethod.GET, RequestMethod.POST})
	public String checkid(@RequestParam("id") String id) {
		System.out.println("[UserController]: checkid");
		
		String result = userService.checkId(id);
		System.out.println(result);
		
		return result;
	}
}
