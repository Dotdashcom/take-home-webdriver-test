package testcases;

import java.io.IOException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class JavaScriptErrorTest extends TestBase {
	
	public JavaScriptErrorTest() throws IOException {
		super();	
	}
	
	@Test 
	public void verifyJavaScriptError()
	{
		driver.get(urlvalues.url_javascripterror);
		
		//read the logs from the browser and pass it into entries 
		LogEntries logEntries =  driver.manage().logs().get(LogType.BROWSER);
		for(LogEntry entry  : logEntries)
		{
			//get specific error message in JavaScript
			String s1 = entry.getMessage();
			System.out.println(s1);
			String[] str = s1.split(":");
			String s2 =str[4].trim();
			String errormsg = "Cannot read property 'xyz' of undefined";
			Assert.assertEquals(s2, errormsg);
			System.out.println("error message has been displayed");		
		}
	}
}
