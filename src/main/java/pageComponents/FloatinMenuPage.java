package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FloatinMenuPage
{
	WebDriver driver;
	public FloatinMenuPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By menuHeaderElement = By.xpath("//h3[contains(text(),'Floating Menu')]");
	
	public String getHeaderText()
	{
		return driver.findElement(menuHeaderElement).getText();
	}
}
