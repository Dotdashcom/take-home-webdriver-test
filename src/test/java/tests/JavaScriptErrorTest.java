package tests;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.JavaScriptErrorPage;
import Utility.InternetWebBaseTest;

public class JavaScriptErrorTest extends InternetWebBaseTest{
	@Test
	public void testJavaScriptError() throws IOException {
			driver.get(loadProperties().getProperty("BASE_URL")+"javascript_error");
			JavaScriptErrorPage errorMsg=new JavaScriptErrorPage(driver);
			String text=errorMsg.gettext();
			Assert.assertTrue(text.equals("This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques."),"User given text is not correct");
			
			/*Set<String> logtyp = driver.manage().logs().getAvailableLogTypes();
		      for (String s : logtyp) {
		         System.out.println(logtyp);
			LogEntries logEntries=driver.manage().logs().get(LogType.BROWSER);


			for (LogEntry entry : logEntries) {
				System.out.println(entry);
	        }
			Assert.assertTrue(logEntries.getAll().get(1).toString().contains("Cannot read properties of undefined (reading 'xyz')"));
		}*/
	}

}
