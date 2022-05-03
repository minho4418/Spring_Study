package com.my.sales.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sales.controller.ProductController;
import com.my.sales.dto.Product;
import com.my.sales.repository.ProductRepository;

@Service
public class ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	public Map<String, Object> insert(Product product) {
		//code msg: 0 성공, 1 실패
		Map<String, Object> rmap = new HashMap<>();
		 
		int cnt = productRepository.insert(product);
		logger.info(cnt+"건 추가");
		if (cnt == 0) { //실패
			rmap.put("code", 1);
			rmap.put("msg", "실패");
			return rmap;
		}
		//성공시
		rmap.put("code", 0);
		rmap.put("msg", "추가완료");
		return rmap;
	}

	public List<Product> selectList(String findvalue) {
		
		return productRepository.selectList(findvalue);
	}

	public Product selectOne(String pcode) {
		
		return productRepository.selectOne(pcode);
	}

	public int update(Product product) {
		
		return productRepository.update(product);
	}

	public int delete(String pcode) {
		// TODO Auto-generated method stub
		return productRepository.delete(pcode);
	}

}
