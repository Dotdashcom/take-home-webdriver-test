package WebTesting.SeleniumWebTesting;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class jsErrorTest  extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
	}
	
	@Test()
	public void jsErrorTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/javascript_error");
		String expectedHomePageURL = "Page with JavaScript errors on load";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//getting all the logentries 
	    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	    //splitting multiple entries to one by one scaning
		for (LogEntry logEntry : logEntries) 
		{
	    		String expected = "http://localhost:7080/javascript_error 6:51 Uncaught TypeError: Cannot read property 'xyz' of undefined";
	    		//Checking if the error is equal to as expected 
	    		Assert.assertEquals(logEntry.getMessage(), expected);
	    		//breaking as we will find expected error in first scan
	    		break;
	    }
		
	}
	
	
	@AfterTest
	public void teardown()
	{
		//closing and the quiting the driver
		//driver.close();	
		//driver.quit();
	}
}
