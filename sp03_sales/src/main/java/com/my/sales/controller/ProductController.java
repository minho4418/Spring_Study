package com.my.sales.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.sales.dto.Product;
import com.my.sales.service.ProductService;

@Controller
@RequestMapping("product") //클래스의 매핑정보
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	//DI:자동주입
	@Autowired
	private ProductService productService; 
	
	//상품등록폼으로 이동
	//@RequestMapping(value = "product/add", method = RequestMethod.GET)
	@GetMapping("add")
	public void add() {
		//return "product/add";
	}
	
	//상품등록버튼 클릭시
	//@RequestMapping(value = "product/add" , method = RequestMethod.POST)
	@PostMapping("add")
	public String add(Product product, RedirectAttributes rattr) {
		logger.info(product.toString());
		//rmap : code:0,msg:정상  code:1, msg:중복
		Map<String, Object> rmap =productService.insert(product);
		logger.info(rmap.toString());
		//redirect이동, msg전달
		int code = (int) rmap.get("code");
		rattr.addFlashAttribute("msg", rmap.get("msg"));
		//성공시 list이동
		if (code == 0) {
			//리졸버 작동안됨, 
			// /product/add => /product/
			return "redirect:/product/"; //컨트롤러 호출(절대경로)
		}
		//실패시 add이동
		return "redirect:add"; //상대경로
	}
	
	//리스트폼으로 이동
	@GetMapping("/")
	public String list() {
		//리졸버작동: /WEB-INF/views/product/list.jsp
		return "product/list";
	}
	
	//조회버튼을 눌렀을때
	@GetMapping("list")
	public String list(@RequestParam(defaultValue = "") String findvalue, Model model) {
		logger.info(findvalue);
		List<Product> plist = productService.selectList(findvalue);
		logger.info(plist.toString());
		
		model.addAttribute("plist", plist);
		//양 많으니 forwarding방식
		//리졸버 : prefix, suffix -> servlet-context
		
		return "product/list";
	}
	
	//수정폼으로 이동
	@GetMapping("modify")
	public void modify(@RequestParam String pcode, Model model) {
		logger.info(pcode);
		//한건조회
		Product product = productService.selectOne(pcode);
		model.addAttribute("product", product);
		
		logger.info(product.toString());
	}
	
	//수정버튼을 눌렀을때
	@PostMapping("modify")
	public String modify(@ModelAttribute Product product, RedirectAttributes rattr) {
		logger.info(product.toString());
		//한건조회
		int cnt = productService.update(product);
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
		return "redirect:list"; //상대경로 컨트롤러의 매핑 호출
	}
	
	//메소드는 상관이 없고 url만 일치
	//@RequestMapping(value ="remove", method = RequestMethod.GET)
	@GetMapping("remove")
	public String remove(@RequestParam String pcode, RedirectAttributes rattr) {
		logger.info(pcode);
		int cnt = productService.delete(pcode);
		rattr.addFlashAttribute("msg", "삭제완료"); //redirect시 파라메터 보내기(한번사용후 삭제)
		//주소변경:jsp호출안됨
		return "redirect:list"; //컨트롤러 호출
	} 
	
}
