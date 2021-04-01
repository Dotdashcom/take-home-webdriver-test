package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenu_page 
{
	WebDriver driver;
	
	public ContextMenu_page(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath = "//div[@id='hot-spot']")
	public WebElement contextRectangle;
}
