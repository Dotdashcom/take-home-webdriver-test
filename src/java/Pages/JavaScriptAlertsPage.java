package java.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavaScriptAlertsPage {

	WebDriver driver;
	
	public JavaScriptAlertsPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
	WebElement JSAlertButton;
	
	
	@FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
	WebElement JSConfirmButton;
	
	
	@FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
	WebElement JDPrompt;
	
	
	
	public void alertHandling()
	{
		
		//JSAlertButton.click();
		
		
		
		for(int i=1;i<3;i++)
		{
			WebElement button = driver.findElement(By.xpath("(//ul//li//button)["+i+"]"));
			button.click();
			
			Alert alert = driver.switchTo().alert();
			String alertMessage= driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			alert.accept();
			
			int j=1;
			j++;	
			if(j==1)
			{
			Assert.assertEquals(alertMessage, "I am a JS Alert");
			}
			else 
			{
				Assert.assertEquals(alertMessage, "I am a JS Confirm");
			}
			
		}
		
		
		JDPrompt.click();
		
		Alert alert = driver.switchTo().alert();
		String alertMessage= driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.sendKeys("Hello World");
		alert.accept();
		
		Assert.assertEquals(alertMessage, "I am a JS prompt");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
