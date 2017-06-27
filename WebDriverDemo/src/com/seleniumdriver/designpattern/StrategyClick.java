package com.seleniumdriver.designpattern;

import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrategyClick {
	//private static final Logger logger = LoggerFactory.getLogger(StrategyClick.class);
	
	public static void main(String args[]) { 
		List<Message> messages = new ArrayList<Message>(); 
		messages.add(new Message(MessageType.TEXT, 100, "This is test message")); 
		messages.add(new Message(MessageType.XML, 200, "How are you ")); 
		messages.add(new Message(MessageType.TEXT, 300, "Does Strategy pattern follows OCP design principle?")); 
		messages.add(new Message(MessageType.TEXT, 400, "Wrong Message, should be filtered")); 
		messages = filter(messages, new FilterByType(MessageType.XML)); 
		messages = filter(messages, new FilterByKeyword("Wrong")); 
		messages = filter(messages, new FilterBySize(200)); }

/* * This method confirms Open Closed design principle, 
 * * It's open for modification, because 
 * * you can provide any filtering criterion by providing 
 * * implementation of FilteringStrategy, but 
 * * no need to change any code here. 
 * New functionality will be provided by new code. 
 * */ 

public static final List<Message> filter(List<Message> messageList, FilterStrategy strategy){ 
	Iterator<Message> itr = messageList.iterator(); 
	while(itr.hasNext()){ 
		Message msg = itr.next(); 
		if(strategy.isFilterable(msg)){ 
			//logger.info(strategy.toString() + msg);
			System.out.println("Message : " + strategy.toString() + msg);
			itr.remove(); 
			} 
		} 
	return messageList; 
	} 
}


