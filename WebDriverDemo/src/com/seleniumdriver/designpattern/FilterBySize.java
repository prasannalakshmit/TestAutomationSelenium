package com.seleniumdriver.designpattern;

/* * Another Strategy implementation for filtering message by size 
 * */ 
public class FilterBySize implements FilterStrategy { 
	private int maxSize; 
	public FilterBySize(int maxSize) { 
		this.maxSize = maxSize; 
		} 
	 
	public boolean isFilterable(Message msg) { 
		return msg.getSize() > maxSize; 
		} 
	@Override 
	public String toString() { 
		return "Filtering By maxSize: " + maxSize; 
		} 
	}

