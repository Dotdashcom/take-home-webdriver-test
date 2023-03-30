package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenNewWindowPage
{
	WebDriver driver;
	public OpenNewWindowPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By clickHereLinkElement = By.xpath("//a[contains(text(),'Click Here')]");
	By newWindowMessage = By.xpath("//h3[contains(text(),'New Window')]");
	
	public void clickTheLink()
	{
		driver.findElement(clickHereLinkElement).click();
	}
	
	public String getNewWindowMessage()
	{
		return driver.findElement(newWindowMessage).getText();
	}
}
