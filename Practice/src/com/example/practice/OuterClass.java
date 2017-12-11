package com.example.practice;

import java.util.Date;

public final class OuterClass {

	private Integer val;
	private String str;
	private Date hireDate;

	public OuterClass(Integer val, String str, Date hireDate) {
		this.val = val;
		this.str = str;
		this.hireDate = hireDate;
	}

	public Integer getVal() {
		return val;
	}

	public String getStr() {
		return str;
	}

	public Date getHireDate() {
		return (Date) hireDate.clone();
	}

	public static void main(String[] args) {
		OuterClass o = new OuterClass(1, "vishal", new Date());
		System.out.println("Id " + o.getVal());
		System.out.println("Name " + o.getStr());
		System.out.println("Date " + o.getHireDate().toString());
		
		o.getHireDate().setDate(15);
		System.out.println("Date modified "+o.getHireDate());
	}
}