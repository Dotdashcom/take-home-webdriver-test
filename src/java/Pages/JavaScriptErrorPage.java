package java.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class JavaScriptErrorPage {
	
	WebDriver driver;
	
	public JavaScriptErrorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	@FindBy(xpath = "//body//p")
	WebElement error;
	
	
	
	public void testJavaScriptError()
	{
		String errorMsg = error.getText();
		System.out.println(errorMsg);
		String Expected = "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.";
		Assert.assertEquals(errorMsg, Expected);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
