package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage
{
	WebDriver driver;
	public DynamicLoadingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By startButtonElement = By.xpath("//button[contains(text(),'Start')]");
	By helloWorldElement = By.id("finish");
	
	public void clickStartButton()
	{
		driver.findElement(startButtonElement).click();
	}
	public String getFinishedMessage()
	{
		return driver.findElement(helloWorldElement).getText();
	}
	public By getMessageElement()
	{
		return helloWorldElement;
	}
}
