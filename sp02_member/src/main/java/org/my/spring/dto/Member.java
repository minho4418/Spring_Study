package org.my.spring.dto;

public class Member {
	private String email;
	private String passwd;
	private String name;
	public Member() {
		super();
	}
	public Member(String email, String passwd, String name) {
		super();
		this.email = email;
		this.passwd = passwd;
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [email=" + email + ", passwd=" + passwd + ", name=" + name + "]";
	}
	
	
}
