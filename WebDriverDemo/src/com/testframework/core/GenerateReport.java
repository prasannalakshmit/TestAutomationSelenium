package com.testframework.core;
import java.io.File;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateReport {
  
  public void f() {
}
  //@Test
  //public void verifySeleniumBlog() {
	  
/*		String extentReportFile = "C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\src\\ExtentReports1.html";
	    //File extentReportFile= new File ("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/src/Report.html");
		//String extentReportImage = "C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\src\\extentReportImage.png";
		String extentReportImage = "C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\screenshot.JPEG";

		// Create object of extent report and specify the report file path.
		ExtentReports extent = new ExtentReports(extentReportFile, false);

		// Start the test using the ExtentTest class object.
		ExtentTest extentTest = extent.startTest("My First Test",
				"Verify WebSite Title");
		System.setProperty("webdriver.ie.driver", "C:\\Lakshmi\\TestAutomationSelenium\\Drivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		// Launch the FireFox browser.
		//WebDriver driver = new FirefoxDriver();

		//driver.manage().window().maximize();

		extentTest.log(LogStatus.INFO, "Browser Launched");

		// Open application.
		//driver.get("/");
		driver.get("www.techbeamers.com");
		extentTest.log(LogStatus.INFO, "Navigated to www.techbeamers.com");

		// get title.
		String title = driver.getTitle();

		extentTest.log(LogStatus.INFO, "Get the WebSite title");

		// Verify title.
		//Assert.assertTrue(title.contains("Selenium Webdriver"));
		try{
		Assert.assertTrue(title.contains("Selenium Webdriver"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		extentTest.log(LogStatus.PASS, "Title verified");

		// In case you want to attach screenshot then use below method
		// We used a random image but you've to take screenshot at run-time
		// and specify the error image path.
		extentTest.log(
				LogStatus.INFO,
				"Error Snapshot : "
						+ extentTest.addScreenCapture(extentReportImage));

		// Close application.
		driver.quit();

		extentTest.log(LogStatus.INFO, "Browser closed");

		// close report.
		extent.endTest(extentTest);

		// writing everything to document.
		extent.flush();*/
		public static void main(String... string){
		System.out.println("testing");
		//extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/MyOwnReport.html", true);
		
		ExtentReports extent = new ExtentReports("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\src\\MyReport.html", false);
		System.out.println("File given");
		ExtentTest extentTest = extent.startTest("My First Test","Verify WebSite Title");
		System.out.println("Test Started");
		extentTest.log(LogStatus.INFO, "Browser Launched");
		extent.endTest(extentTest);
		extent.flush();
        System.out.println("testing");
	}
}

