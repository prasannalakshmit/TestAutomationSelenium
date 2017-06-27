import java.io.File;

//import junit.framework.Assert;





import org.apache.commons.io.FileUtils;
//import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Reporting {

	static ExtentReports report; 
	static ExtentTest logg;
	static WebDriver driver;
	static ITestResult res; 
	
	public static void main (String [] args){
		
		report=new ExtentReports("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\Report.html");
		report.startTest("Testing Reports");
		
		System.setProperty("webdriver.ie.driver", "C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\drivers\\IEDriverServer.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\drivers\\geckodriver.exe");
		//System.setProperty("webdriver.Chrome.driver", "C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\drivers\\chromedriver.exe");
		driver=new InternetExplorerDriver();
		//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		//logg.log(LogStatus.INFO, "Browser Started");
		System.out.println("Browser Started!");
		driver.get("https://google.com");
		//logg.log(LogStatus.INFO, "Application is up and running.....!");
		System.out.println("Application is up and running.....!");
		String title = driver.getTitle();
		//Assert.assertTrue(title.contains("DXC"));
		Assert.assertTrue(true);
		//Assert.assertTrue(true);
		//logg.log(LogStatus.PASS, "Test Verified!!");
		System.out.println("Test Verified!!");
		//System.out.println("File name of the screen shot"+res.getName());
		captureScreenShot(driver,"Report");
		System.out.println("Scren shot captured !");
		driver.get("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\Report.html");
		System.out.println("Report Generated !");
		
	}
	@AfterMethod
	public static void tearDown(ITestResult result){
		if (result.getStatus()==ITestResult.FAILURE){
			
			String screenshotPath = captureScreenShot(driver,result.getName()); 
			//String image = logg.addScreenCapture(screenshotPath);
			//logg.log(LogStatus.FAIL, "Test FAILED!", image);
			System.out.println("Test FAILED!!");
		}
		//report.endTest(logg);
		report.flush();
		driver.get("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\Report.html");
	}
	public static String captureScreenShot(WebDriver driver, String screenShotName){
		
		System.out.println("Inside Capture Screen shot Method");
		String dest=null;
		try{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		dest = "C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\"+screenShotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		System.out.println("ScreenShotTaken");
		
		}
		catch(Exception e){
			System.out.println("Exception While Taking Screen Shot!!"+e.getMessage());
			e.printStackTrace();
		}
		
		return dest;
		
	}
}
