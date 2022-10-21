package PageObjects;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class JavaScriptErrorPO {

	WebDriver driver;
	public JavaScriptErrorPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void javaScriptError() throws InterruptedException  {
		
			String ExpectedErrorr = "Cannot read property 'xyz' of undefined";
			LogEntries logs = driver.manage().logs().get(LogType.DRIVER);
			for (org.openqa.selenium.logging.LogEntry error : logs) {

				assertTrue(error.getMessage().contains(ExpectedErrorr));
				System.out.println(error.getMessage());
				break;
			}
			}
	
	}



