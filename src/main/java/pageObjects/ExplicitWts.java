package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 

public class ExplicitWts { 

	
	public WebDriver driver;
	By startLocator = By.xpath("//*[@id=\'start\']/button");
	By textLocator = By.xpath("//*[@id=\'finish\']/h4");
	
	public ExplicitWts(WebDriver driver)
	{ 
		this.driver=driver;
	}
	
	public WebElement getStartLocator()
	{
		return driver.findElement(startLocator);
		
	}
	public By getTextLocator()
	{
		return textLocator;
	}
}
