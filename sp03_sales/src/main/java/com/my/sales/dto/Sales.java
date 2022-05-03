package com.my.sales.dto;

import java.util.Date;

public class Sales {
	private int seq;
	private String sdate;
	private String pcode;
	private int qty;
	private int amount;
	private Date regidate;
	public Sales() {
		super();
	}
	public Sales(int seq, String sdate, String pcode, int qty, int amount, Date regidate) {
		super();
		this.seq = seq;
		this.sdate = sdate;
		this.pcode = pcode;
		this.qty = qty;
		this.amount = amount;
		this.regidate = regidate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	@Override
	public String toString() {
		return "Sales [seq=" + seq + ", sdate=" + sdate + ", pcode=" + pcode + ", qty=" + qty + ", amount=" + amount
				+ ", regidate=" + regidate + "]";
	}
	
}
