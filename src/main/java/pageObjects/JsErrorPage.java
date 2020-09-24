package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsErrorPage {

	public WebDriver driver;
	
	By jsErrorLocator = By.xpath("/html/body");
	
	public JsErrorPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getJsErrorLocator()
	{
		return driver.findElement(jsErrorLocator);
	}
}
