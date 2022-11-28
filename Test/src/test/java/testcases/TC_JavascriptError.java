package testcases;


import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_JavascriptError extends BaseClass {
	

	@Test
	public void VerifyJavaScriptError() throws InterruptedException {
	
	   
	      driver.get("http://localhost:7080/javascript_error");
	      LogEntries jserror = driver.manage().logs().get(LogType.BROWSER);
	      System.out.println("All Log printed" + jserror.getAll());
	      System.out.println("All Log printed" + jserror.getAll().get(0));
	      
	      Thread.sleep(2000);
	      Assert.assertTrue(jserror.getAll().get(1).toString().contains("Cannot read properties of undefined (reading 'xyz')"));
	      
	     

}
}
