
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class LoggingManager {
	
	public void getLogManager() throws IOException{
		try{
				LogManager.getLogManager().readConfiguration(new FileInputStream("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/lib/log4j.properties"));
		}catch(IOException ioEx){
			System.out.println("Exception occured" +ioEx.getMessage());
			ioEx.printStackTrace();
		}
	}

}
