package com.mycompany.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycompany.myapp.dto.Member;
import com.mycompany.myapp.repository.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setEmail("park@gmail.com");
		member.setPasswd("1111");
		member.setUsername("박자바");
		member.setZipcode("11111");
		member.setAddrload("신림로");
		member.setAddrdetail("6층");
		member.setFilename("a.png");
		
		int cnt = memberRepository.insert(member);
		System.out.println(cnt +"건 추가");
	}

	@Test
	public void testUpdate() {
		Member member = new Member();
		member.setEmail("park@gmail.com");
		member.setPasswd("1111");
		member.setUsername("박자바");
		member.setZipcode("11111");
		member.setAddrload("신림로");
		member.setAddrdetail("6층");
		member.setFilename("a.png");
		
		int cnt = memberRepository.update(member);
		System.out.println(cnt +"건 수정");
	}

	@Test
	public void testDelete() {
		int cnt = memberRepository.delete("park@gmail.com");
		System.out.println(cnt +"건 삭제");
	}

	@Test
	public void testSelectOne() {
		Member member = memberRepository.selectOne("park@gmail.com");
		System.out.println(member);
	}

	@Test
	public void testSelectList() {
		Map<String,String> map = new HashMap<>();
		map.put("findkey", "username");
		map.put("findvalue", "");
		List<Member> mlist= memberRepository.selectList(map);
		System.out.println(mlist);
	}

}
