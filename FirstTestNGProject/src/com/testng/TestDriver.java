package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDriver {
	
	public WebDriver driver ; 
	
	 @Test
	  public void verifyHomepageTitle() {
		  
		  System.out.println("launching IE browser"); 
	      //System.setProperty("webdriver.firefox.marionette", driverPath);
	      System.setProperty("webdriver.ie.driver", "C:\\Lakshmi\\TestAutomationSelenium\\Drivers\\IEDriverServer.exe");
	      //driver = new FirefoxDriver();
	      driver = new InternetExplorerDriver();
	      driver.manage().window().maximize();
	      //driver.get(baseUrl);
	      //String expectedTitle = "WebDriver";
	      String expectedTitle = "Google";
	      String actualTitle = driver.getTitle();
	      /*String actualTitle =  
	      System.out.println("Actual Title : "+actualTitle);
	     */ try{
	      Assert.assertEquals(actualTitle, expectedTitle);
	      }
	      catch(Exception e){
	    	  e.getMessage();
	    	  e.printStackTrace();
	    	  System.out.println("Exception occured!");
	      }
	      finally{
	    	  driver.close();  
	      }
	      
	  
	  }

}
