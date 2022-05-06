package com.my.sales.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sales.dto.Sales;
import com.my.sales.repository.SalesRepository;

@Service
public class SalesService {
	@Autowired
	private SalesRepository salesRepository; 
	
	public int insert(Sales sales) {
		return salesRepository.insert(sales);
	}

	//판매조회
	public List<Map<String, Object>> selectList(Map<String, String> findmap) {
		return salesRepository.selectList(findmap);
	}

	public Sales selectOne(int seq) {
		// TODO Auto-generated method stub
		return salesRepository.selectOne(seq);
	}

	public int update(Sales sales) {
		// TODO Auto-generated method stub
		return salesRepository.update(sales);
	}

	public int delete(int seq) {
		// TODO Auto-generated method stub
		return salesRepository.delete(seq);
	}

}
