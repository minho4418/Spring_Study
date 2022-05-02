package org.my.spring;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.my.spring.dao.MemberRepository;
import org.my.spring.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//스프링 테스트
//스프링 객체자동 생성 : (1)bean태그 (2)어노테이션 붙은 클래스
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTest {
	//자동주입 :DI(형이나 이름이 일치하는 스프링인 생성한 객체를 대입)  
	@Autowired
	private DataSource dataSource; //root-context.xml에서 bean생성
	
	@Test
	public void testDataSource() {
		try {
			Connection conn = dataSource.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//마이바티스 팩토리 테스트
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testSessionFactory() {
		System.out.println(sqlSessionFactory);
	}
	
	//마이바티스 세션 테스트
	@Autowired
	private SqlSession sqlSession;
	@Test
	public void testSqlSession() {
		System.out.println(sqlSession.getConnection());
	}
	
	
	//dao테스트
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setEmail("park@gmail.com");
		member.setPasswd("3333");
		member.setName("박자바");
		
		int cnt = memberRepository.insert(member);
		System.out.println(cnt+"건 저장");
	}
	
	//수정테스트
	@Test
	public void testUpdate() {
		Member member = new Member();
		member.setEmail("hong@gmail.com");
		member.setName("박보검");
		member.setPasswd("2222");
		int cnt = memberRepository.update(member);
		System.out.println(cnt+"건 수정");
	}
	
	@Test
	public void testDelete() {

		int cnt = memberRepository.delete("hong@gmail.com");
		System.out.println(cnt+"건 삭제");
	}
	
	@Test
	public void testSelectOne() {
		Member member = memberRepository.selectOne("hong@gmail.com");
		System.out.println(member);
	}
	
	@Test
	public void testSelectList() {
		List<Member> mlist = memberRepository.selectList();

		System.out.println(mlist);
	}
	
	

}
