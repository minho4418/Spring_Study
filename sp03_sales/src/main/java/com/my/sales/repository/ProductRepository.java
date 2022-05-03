package com.my.sales.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.sales.dto.Product;

@Repository
public class ProductRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	//상품 추가
	public int insert(Product product){
		try {
			return sqlSession.insert("com.my.sales.ProductMapper.insert", product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; //예외발생시 0 리턴
	}

	public List<Product> selectList(String findvalue) {
		
		return sqlSession.selectList("com.my.sales.ProductMapper.selectList",findvalue);
	}

	public Product selectOne(String pcode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.my.sales.ProductMapper.selectOne",pcode);
	}

	public int update(Product product) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.sales.ProductMapper.update",product);
	}

	public int delete(String pcode) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.my.sales.ProductMapper.delete",pcode);
	}

}
