package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsalertPage {
	public WebDriver driver;
	By clickForJsAlert = By.xpath("//*[@id=\'content\']/div/ul/li[1]/button");
	By clickForJsConfirm = By.xpath("//*[@id=\'content\']/div/ul/li[2]/button");
	By clickForJsPrompt = By.xpath("//*[@id=\'content\']/div/ul/li[3]/button");
	
	public JsalertPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getClickForJsAlert()
	{
		return driver.findElement(clickForJsAlert);
		
	}
	public WebElement getClickForJsConfirm()
	{
		return driver.findElement(clickForJsConfirm);
	}
  
	public WebElement getClickForJsPrompt()
	{
		return driver.findElement(clickForJsPrompt);
	}
}
