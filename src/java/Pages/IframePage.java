package java.Pages;

import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IframePage {

	WebDriver driver;
	
	public IframePage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement textbox;
	
	
	public void handleIframes() throws InterruptedException
	{
		driver.switchTo().frame("mce_0_ifr");// Switch By ID
		textbox.clear();
		textbox.sendKeys("hello world");
		
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  

		WebElement inpElement = driver.findElement(By.id("inputTag"));
		String text = (String) js.executeScript("return arguments[0].value", inpElement);
		
		Assert.assertEquals(text, "hello world");
	}
	
	
	
}
