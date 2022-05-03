package com.my.sales.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.sales.dto.Product;
import com.my.sales.dto.Sales;

@Repository
public class SalesRepository {
	@Autowired
	private SqlSession sqlSession;
	//상품 추가
	public int insert(Sales sales){
		try {
			return sqlSession.insert("com.my.sales.SalesMapper.insert", sales);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; //예외발생시 0 리턴
	}
}
