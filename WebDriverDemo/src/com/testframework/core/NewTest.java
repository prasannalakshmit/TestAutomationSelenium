package com.testframework.core;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.seleniumdriver.gsd.core.logging.*;

public class NewTest {
	public static WebDriver driver;
	static Logger logger = Logger.getLogger(Log.class.getName());
	
  @Test
  public void f() {
	  
  }
  	
	
	public void getScreenShot(){
		
		System.setProperty("webdriver.ie.driver", "C:\\Lakshmi\\TestAutomationSelenium\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://google.com");
		//driver.manage().window().maximize();
		driver.findElement(By.id("lst-ib")).sendKeys("Google");
		logger.info("Getting the screen shot");
		try{
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\screenshot.JPEG"));
			}catch(Exception e){
				e.getMessage();
				e.printStackTrace();
			}
		}
}
