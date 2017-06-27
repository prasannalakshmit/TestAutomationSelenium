package com.seleniumdriver.designpattern;

/* * interface which defines Strategy for this pattern. */ 
public interface FilterStrategy { 
	public boolean isFilterable(Message msg); 
	}


