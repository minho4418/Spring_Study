package com.my.sales.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sales.dto.Product;
import com.my.sales.dto.Sales;
import com.my.sales.repository.ProductRepository;
import com.my.sales.repository.SalesRepository;

@Service
public class SalesService {
private static final Logger logger = LoggerFactory.getLogger(SalesService.class);
	
	@Autowired
	private SalesRepository salesRepository;
	
	public Map<String, Object> insert(Sales sales) {
		//code msg: 0 성공, 1 실패
		Map<String, Object> rmap = new HashMap<>();
		 
		int cnt = salesRepository.insert(sales);
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
}
