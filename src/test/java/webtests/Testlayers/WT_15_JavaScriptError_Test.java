package webtests.Testlayers;

import java.time.Duration;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_015_JavaScriptError_POM;

public class WT_15_JavaScriptError_Test extends WT_BaseClass{

	WT_015_JavaScriptError_POM jse;
	
	//Constructor
	public WT_15_JavaScriptError_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
	
	jse = new WT_015_JavaScriptError_POM();
	
	driver.get(pr.getProperty("baseurl")+"/javascript_error");
	 logg.info("****JavaScriptError url entered****");
    }
	
	@Test
	public void JavaScriptErrorTest() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(jse.ErrorMessage()));
		
	 Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();
	 for(String string : logTypes) {
		 System.out.println(string);
	 	
	LogEntries logEntries= driver.manage().logs().get(LogType.BROWSER);
	List<LogEntry> logs = logEntries.getAll();
	
	 for(LogEntry entry : logs) {
	 System.out.println(entry);
	 
	 boolean msg = logs.toString().contains("Cannot read properties of undefined (reading 'xyz')"); 
	 Assert.assertEquals(msg, true); 
	 logg.info("****Test Passed****");
		}
 
	 	}}
	}
	

