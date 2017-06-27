package com.seleniumdriver.designpattern;

/* * Another Strategy implementation for filtering message by keyword in content. */ 
public class FilterByKeyword implements FilterStrategy { 
	private String keyword; 
	public FilterByKeyword(String keyword) { 
		this.keyword = keyword; 
		} 
	public String getKeyword() { 
		return keyword; 
		} 
	public void setKeyword(String keyword) { 
		this.keyword = keyword; 
		} 
	public boolean isFilterable(Message msg) { 
		return msg.getContent()==null || msg.getContent().contains(keyword); 
		} 
	@Override public String toString() { 
		return "Filtering By keyword: " + keyword; 
		} 
	}