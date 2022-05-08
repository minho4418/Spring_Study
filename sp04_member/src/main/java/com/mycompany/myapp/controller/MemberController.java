package com.mycompany.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	//1)컴파일타임:문법적인 에러 체크
	//		인테페이스의 메소드 체크
	//2)런타임 : 실행시 체크
	//		객체를 생성해서 DI(자동주입)
	//      MemberServiceImpl객체가 주입(다형성이용)
	//      필드선언은 인터페이스로 
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public void join() {
	}
}
