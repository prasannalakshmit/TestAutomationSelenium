package com.seleniumdriver.gsd.core.logging;

import java.util.logging.Logger;

public class Log {
	
	 static Logger logger = Logger.getLogger(Log.class.getName());
	 
	 public static void main(String [] args){
		 logger.info("Hello this is an info message");
	 }
}
