package com.my.sales.dto;

import java.util.Date;

public class Product {
	private String pcode;
	private String pname;
	private int price;
	private Date regidate;
	public Product() {
		super();
	}
	public Product(String pcode, String pname, int price, Date regidate) {
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.price = price;
		this.regidate = regidate;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	@Override
	public String toString() {
		return "Product [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", regidate=" + regidate + "]";
	}
	
	
}
