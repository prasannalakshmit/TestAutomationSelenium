package com.seleniumdriver.gsd.core.logging;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingManager {
		
		static Logger logger = Logger.getLogger(Log.class.getName());
		
		public void getLogManager() throws IOException{
			try{
					LogManager.getLogManager().readConfiguration(new FileInputStream("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/src/log4j.properties"));
			}catch(IOException ioEx){
				System.out.println("Exception occured" +ioEx.getMessage());
				ioEx.printStackTrace();
			}
		}
		public static Handler getFileHandler(String filePath) throws IOException{
			Handler fileHandler = null;
			try{
			fileHandler = new FileHandler("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/log/Application.log", true);
			logger.info( "Log File Path is : "+filePath);
			fileHandler.setFormatter(new MyFormatter());
			logger.addHandler(fileHandler);
			
			}
			catch(Exception e){
				logger.getLevel();
				logger.info("Exception Occured writing the log file");
				logger.info(e.getMessage());
				e.printStackTrace();
			}finally{
				
			}
			
			return fileHandler;	
		}
		
}
