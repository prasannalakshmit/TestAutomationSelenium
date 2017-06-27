import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Report {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("testing");
		//extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/MyOwnReport.html", true);
		
		ExtentReports extent = new ExtentReports("C:\\Lakshmi\\MyReport2.html", false);
		System.out.println("File given");
		ExtentTest extentTest = extent.startTest("My First Test");
		System.out.println("Test Started");
		extentTest.log(LogStatus.INFO, "Browser Launched");
		extent.endTest(extentTest);
		extent.flush();
        System.out.println("testing");
	}
		

}
