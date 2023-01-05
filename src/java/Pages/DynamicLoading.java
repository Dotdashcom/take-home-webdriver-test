package java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoading {

	WebDriver driver;
	
	public DynamicLoading(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//button")
	WebElement startButton;
	
	@FindBy(xpath = "//div//h4[contains(text(),'Hello World')]")
	WebElement hellowWorldtext;
	
	
	
	public void dynamicLodingFunctionality()
	{
		startButton.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//h4[contains(text(),'Hello World')]")));
		
		Assert.assertTrue(hellowWorldtext.isDisplayed(), "hello world msg is not displayed");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
