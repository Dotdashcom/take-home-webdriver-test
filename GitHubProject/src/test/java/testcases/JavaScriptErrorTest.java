package testcases;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

public class JavaScriptErrorTest extends BaseTestMethods {
	
  @Test(priority=1)
  public void JSErrorTest() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/javascript_error");
	 
     
      LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
      List<LogEntry> lg = logEntries.getAll();

      for(LogEntry logEntry : lg) {
         System.out.println(logEntry);
      }
      Assert.assertTrue( lg.get(0).toString().contains(" Cannot read properties of undefined (reading 'xyz')"));

	  }
	  
}
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
