package com.seleniumdriver.designpattern;

/* * An implementation of Strategy interface, which decides to filter 
 * * message by type. 
 * */ 
public class FilterByType implements FilterStrategy { 
	private MessageType type; 
	public FilterByType(MessageType type) { 
		this.type = type; 
		} 
	 
	public boolean isFilterable(Message msg) { 
		return type == msg.getType(); 
		} 
	@Override 
	public String toString() { 
		return "Filtering By type: " + type; 
		} 
	}

