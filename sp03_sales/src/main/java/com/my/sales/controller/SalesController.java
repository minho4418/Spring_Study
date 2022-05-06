package com.my.sales.controller;

import java.util.List;import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.sales.dto.Product;
import com.my.sales.dto.Sales;
import com.my.sales.service.ProductService;
import com.my.sales.service.SalesService;

@Controller
@RequestMapping("sales")
public class SalesController {
	private static final Logger logger = LoggerFactory.getLogger(SalesController.class);
	
	@Autowired
	private ProductService productService; 
	@Autowired
	private SalesService salesService; 
	
	//판매등록 폼으로 이동
	@GetMapping("add")
	public void add(Model model) {
		//상품리스트 조회
		List<Product> plist = productService.selectList("");
		model.addAttribute("plist", plist);
	}
	
	//등록버튼을 클릭했을때
	@PostMapping("add")
	public String add(@ModelAttribute Sales sales) {
		logger.info(sales.toString());
		int cnt = salesService.insert(sales);
		logger.info(cnt+"건 추가");

		//판매리스트로 이동
		return "redirect:list";
	}
	
	//조회시
	//파라메터값을 map에 담기
	@GetMapping("list")
	public void list(@RequestParam Map<String, String> findmap, Model model) {
		logger.info(findmap.toString());
		
		List<Map<String, Object>> slist = salesService.selectList(findmap);
		logger.info(slist.toString());
		
		//list로 이동
		model.addAttribute("slist", slist);
	}
	
	//수정폼으로 이동
	@GetMapping("modify")
	public void modify(@RequestParam int seq, Model model) {
		logger.info("seq:" + seq);
		//한건조회
		Sales sales = salesService.selectOne(seq);
		logger.info(sales.toString());
		model.addAttribute("sales", sales);
		
		//상품리스트 조회
		List<Product> plist = productService.selectList("");
		model.addAttribute("plist", plist);
		
	}
	
	//수정버튼을 눌렀을때
	@PostMapping("modify")
	public String modify(@ModelAttribute Sales sales, RedirectAttributes rattr) {
		logger.info(sales.toString());
		int cnt = salesService.update(sales);
		logger.info(cnt+"건 수정");
		//조회로 이동
		rattr.addFlashAttribute("msg", "수정 완료");
		return "redirect:list";
		
	}
	
	//삭제버튼을 눌렀을때
	@GetMapping("remove")
	public String remove(@RequestParam int seq, RedirectAttributes rattr) {
		logger.info("seq:" + seq);
		int cnt = salesService.delete(seq);
		logger.info(cnt+"건 삭제");
		//조회로 이동
		rattr.addFlashAttribute("msg", "삭제 완료");
		return "redirect:list";
		
	}
	
	
}
