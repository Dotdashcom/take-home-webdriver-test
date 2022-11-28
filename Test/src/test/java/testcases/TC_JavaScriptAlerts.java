package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.JavaScriptAlert;

public class TC_JavaScriptAlerts extends BaseClass{
	

	
	@Test(priority=1)
	public void VerifyJSAlert() {
		
	driver.get("http://localhost:7080/javascript_alerts");
	        JavaScriptAlert jp = new JavaScriptAlert(driver);
	        jp.clickonJSAlert();
	        jp.clickJSConfirm();
	        jp.clickJSPrompt();
	    }
	}

