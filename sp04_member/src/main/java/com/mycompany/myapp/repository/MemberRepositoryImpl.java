package com.mycompany.myapp.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.mycompany.myapp.MemberMapper.insert", member);
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.myapp.MemberMapper.update", member);
	}

	@Override
	public int delete(String email) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.mycompany.myapp.MemberMapper.delete", email);
	}

	@Override
	public Member selectOne(String email) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.mycompany.myapp.MemberMapper.selectOne", email);
	}

	@Override
	public List<Member> selectList(Map<String, String> map) {
		return sqlSession.selectList("com.mycompany.myapp.MemberMapper.selectList", map);
	}
	
	
	
}
