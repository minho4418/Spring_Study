package com.my.sales.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.sales.dto.Product;
import com.my.sales.dto.Sales;
import com.my.sales.service.ProductService;
import com.my.sales.service.SalesService;

@Controller
@RequestMapping("sales")
public class SalesController {
	private static final Logger logger = LoggerFactory.getLogger(SalesController.class);
	
	//DI:자동주입
	@Autowired
	private ProductService productService;
	
	//판매등록 폼으로 이동
		@GetMapping("add")
		public void add(Model model) {
			//상품리스트 조회
			List<Product> plist = productService.selectList("");
			model.addAttribute("plist", plist);
			
			
		}
		
}