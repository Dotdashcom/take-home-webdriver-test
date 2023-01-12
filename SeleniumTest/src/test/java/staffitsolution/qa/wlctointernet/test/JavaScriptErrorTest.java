package staffitsolution.qa.wlctointernet.test;

import java.util.List;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class JavaScriptErrorTest extends BaseTest{
	
	@Test
	public void javaScriptErrorTest() throws InterruptedException 
	{
		String javascriptErrMsg = "Cannot read properties of undefined (reading 'xyz')";
		driver.get(prop.getProperty("javasripterror"));	
		Thread.sleep(2000);
        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);       
        List<LogEntry> logs= entry.getAll();
        // Printing details separately 
        for(LogEntry e: logs)
        {
        	System.out.println("Message is: " +e.getMessage());  
        	if(e.getMessage().contains("undefined (reading 'xyz')"))
        	Assert.assertTrue(e.getMessage().contains(javascriptErrMsg));
        }		
	}
}
