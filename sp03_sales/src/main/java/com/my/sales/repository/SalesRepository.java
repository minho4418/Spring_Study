package com.my.sales.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.sales.dto.Sales;

@Repository
public class SalesRepository {
	@Autowired
	private SqlSession sqlSession; 
	
	public int insert(Sales sales) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.my.sales.SalesMapper.insert", sales);
	}

	public List<Map<String, Object>> selectList(Map<String, String> findmap) {
		
		return sqlSession.selectList("com.my.sales.SalesMapper.selectList", findmap);
	}

	public Sales selectOne(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.my.sales.SalesMapper.selectOne", seq);
	}

	public int update(Sales sales) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.sales.SalesMapper.update", sales);
	}

	public int delete(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.my.sales.SalesMapper.delete", seq);
	}
	
	public List<Sales> selectList_pcode(String pcode){
		return sqlSession.selectList("com.my.sales.SalesMapper.selectList_pcode",pcode);
		
	}
	
	
	
	
	
	
	
	

}
