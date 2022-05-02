package org.my.spring;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.my.spring.dto.Member;
import org.my.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//스프링 테스트
//스프링 객체자동 생성 : (1)bean태그 (2)어노테이션 붙은 클래스
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTestService {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setEmail("lee@gmail.com");
		member.setPasswd("3333");
		member.setName("이순재");
		
		Map<String, Object> rmap = memberService.insert(member);
		System.out.println(rmap);
	}
	
	@Test
	public void testUpdate() {
		Member member = new Member();
		member.setEmail("lee@gmail.com");
		member.setPasswd("5555");
		member.setName("이선진");
		System.out.println(member);
		
		int cnt = memberService.update(member);
		System.out.println(cnt +"건 수정");
	}
	
	@Test
	public void testDelete() {
		int cnt = memberService.delete("lee@gmail.com");
		System.out.println(cnt +"건 삭제");
	}
	
	@Test
	public void testSelectOne() {
		Member member = memberService.selectOne("hong@gmail.com");
		System.out.println(member);
	}
	
	@Test
	public void testSelectList() {
		List<Member> mlist = memberService.selectList();
		System.out.println(mlist);
	}
	
	
	
	

}
