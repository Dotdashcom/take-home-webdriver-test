package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage
{
	WebDriver driver;
	public JavaScriptAlertPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By jsAlertButtonElement = By.xpath("//button[contains(text(),'Click for JS Alert')]");
	By jsConfirmButtonElement = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
	By jsPromptButtonElement = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
	
	By retultElement = By.id("result");
	
	public void clickJsAlertButton()
	{
		driver.findElement(jsAlertButtonElement).click();
	}
	public void clickJsConfirmButton()
	{
		driver.findElement(jsConfirmButtonElement).click();
	}
	public void clickJsPromptButton()
	{
		driver.findElement(jsPromptButtonElement).click();
	}
	
	public String getResult()
	{
		return driver.findElement(retultElement).getText();
	}
}
