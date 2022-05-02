package org.my.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.my.spring.dao.MemberRepository;
import org.my.spring.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//스프링이 자동 객체 생성
@Service
public class MemberService {
	//자동주입:DI
	@Autowired
	private MemberRepository memberRepository;
	
	//추가
	public Map<String, Object> insert(Member member) {
		Map<String, Object> rmap = new HashMap<>();
		//code:0 성공
		//code:1 중복된 이메일
		
		//회원존재여부 체크
		Member dbmember = memberRepository.selectOne(member.getEmail());
		if (dbmember == null) {
			memberRepository.insert(member);
			rmap.put("code", 0);
			rmap.put("msg", "회원가입 완료");
			return rmap;
		}
		rmap.put("code", 1);
		rmap.put("msg", "중복된 이메일");
		
		return rmap;

	}
	
	public int update(Member member) {
		return memberRepository.update(member);
	}
	
	public int delete(String email) {
		return memberRepository.delete(email);
	}
	
	public Member selectOne(String email) {
		return memberRepository.selectOne(email);
	}
	
	public List<Member> selectList(){
		return memberRepository.selectList();
	}
	
	
	
	
	
	
}
