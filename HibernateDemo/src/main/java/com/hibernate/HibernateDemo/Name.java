package com.hibernate.HibernateDemo;

import javax.persistence.Embeddable;

@Embeddable
public class Name 
{
	private String first1Name;
	private String first2Name;
	
	
	public String getFirst1Name() {
		return first1Name;
	}
	public void setFirst1Name(String first1Name) {
		this.first1Name = first1Name;
	}
	public String getFirst2Name() {
		return first2Name;
	}
	public void setFirst2Name(String first2Name) {
		this.first2Name = first2Name;
	}
	
	
}
