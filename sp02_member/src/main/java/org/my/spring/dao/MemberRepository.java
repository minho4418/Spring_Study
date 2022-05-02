package org.my.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.my.spring.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//dao
//스프링이 객체 자동생성(servlet-context.xml의 설정)
@Repository
public class MemberRepository {

	//DI:자동 주입
	@Autowired
	private SqlSession sqlSession;
	
	//추가
	public int insert(Member member) {
		try {
			return sqlSession.insert("org.my.spring.MemberMapper.insert", member);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//수정
	public int update(Member member) {
		return sqlSession.update("org.my.spring.MemberMapper.update", member);
	}
	
	//삭제
	public int delete(String email) {
		return sqlSession.delete("org.my.spring.MemberMapper.delete", email);
	}
	
	
	//한건조회
	public Member selectOne(String email) {
		return sqlSession.selectOne("org.my.spring.MemberMapper.selectOne", email);
	}
	
	//리스트
	public List<Member> selectList() {
		return sqlSession.selectList("org.my.spring.MemberMapper.selectList");
	}
	
	
	
}
