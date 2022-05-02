package org.my.spring.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.my.spring.dto.Member;
import org.my.spring.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//서블릿역활을 하는 클래스
@Controller
public class MemberController {
	//접근제한자, 공용, 상수, 클래스형, 참조변수(필드) = 클래스형, 스태틱메소드(매개변수)
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//자동주입
	@Autowired
	private MemberService memberService;
	
	//가입폼으로 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String add() {
		//forward => /WEB-INF/views/add.jsp
		//return "forward:/WEB-INF/views/add.jsp";
		//리졸버에 의해서 view이름만 작성
		return "add";
	}
	//가입버튼을 눌렀을때
	//파라메터를 dto에 settint 해준다
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String add(Member member, RedirectAttributes rattr) {
		logger.info(member.toString());
		Map<String, Object> rmap = memberService.insert(member);
		//성공하면(code:0) list이동
		//실패하면(code:1) add로 이동
		logger.info(rmap.toString());
		int code = (int) rmap.get("code");
		rattr.addFlashAttribute("msg", rmap.get("msg"));

		if (code == 0) {
			return "redirect:list";
		}
		return "redirect:join"; 
	}
	
	//리스트로 이동
	@RequestMapping("/")
	public String list() {
		return "list";
	}
	
	//조회를 눌렀을때(데이터조회후 list로 이동)
	@RequestMapping("/list")
	public void list(Model model) {
		List<Member> mlist = memberService.selectList();
		logger.info(mlist.toString());
		model.addAttribute("mlist", mlist);
	}
	
	//수정폼으로 이동
	@RequestMapping(value="modify", method = RequestMethod.GET)
	public void modify(@RequestParam String email, Model model) {
		//한건조회
		logger.info(email);
		Member member =memberService.selectOne(email);
		model.addAttribute("member", member);
		//modify.jsp로 이동
		//매핑정보와 return이 같다면 생략
	}
	
	//수정버튼을 눌렀을때
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute Member member, RedirectAttributes rattr) {
		logger.info(member.toString());
		//수정
		int cnt = memberService.update(member);
		logger.info(cnt+"건 수정");
		
		//리스트이동
		//redirect방식일때 파라메터 보내기(url인코딩 자동)
		//1)addAttribute : jsp에서 param.msg 으로 사용, 
		// 문제점 : 파라메터가 url에 계속 남아있다
		//rattr.addAttribute("msg", "수정완료");
		//2)addFlashAttribute : jsp에서 msg로 사용
		// 장점: 한번만 메시지를 사용하고 소멸
		rattr.addFlashAttribute("msg", "수정완료"); 
		
		//redirct이동 : 주소는 변경, 대량의 정보는 전송안됨
		//404에러 : /WEB-INF 밑의 jsp는 url로 호출불가
		//return "redirect:/WEB-INF/views/list.jsp";
		return "redirect:/list"; //절대경로로 컨트롤러의 매핑 호출
	}
	
	//삭제
	@RequestMapping("remove")
	public String remove(@RequestParam String email, RedirectAttributes rattr) {
		logger.info(email);
		int cnt = memberService.delete(email);
		rattr.addFlashAttribute("msg", "삭제완료"); //redirect시 파라메터 보내기(한번사용후 삭제)
		//주소변경:jsp호출안됨
		return "redirect:/"; //컨트롤러 호출
	}
	
	
	
	
}
