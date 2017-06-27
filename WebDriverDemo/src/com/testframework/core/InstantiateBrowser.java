package com.testframework.core;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.seleniumdriver.gsd.core.logging.Log;

public class InstantiateBrowser {
	
	public static WebDriver driver;
	static Logger logger = Logger.getLogger(Log.class.getName());
	
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
	public void imageToDoc() throws FileNotFoundException, IOException, InvalidFormatException{
		CustomXWPFDocument document = new CustomXWPFDocument(new FileInputStream(new File("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\finallyhurray.doc")));
        FileOutputStream fos = new FileOutputStream(new File("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\TestScreenShot.doc"));

        String blipId = document.addPictureData(new FileInputStream(new File("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\screenshot.JPEG")), Document.PICTURE_TYPE_JPEG);

        System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));

        //System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));
        document.createPicture(blipId,document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG), 500, 500);


        document.write(fos);
        fos.flush();
        fos.close();
	}
	public void verifyTest() {
		  
		String extentReportFile = "C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\src\\MyExtentReports.html";
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
		Assert.assertTrue(title.contains("Selenium Webdriver"));

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
		extent.flush();
	}

	
}
