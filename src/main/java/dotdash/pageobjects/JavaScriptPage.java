package dotdash.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavaScriptPage {
	
public WebDriver driver;
	
	
	
	public JavaScriptPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void captureJsErrorAndVerify(String error)  {
		LogEntries jsErrors=driver.manage().logs().get(LogType.BROWSER);
		Assert.assertTrue(jsErrors.getAll().get(0).toString().contains(error));
		
	}

}
