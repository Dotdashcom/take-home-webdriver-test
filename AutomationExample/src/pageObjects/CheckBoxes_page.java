package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxes_page 
{
	WebDriver driver;
	
	public CheckBoxes_page(WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy(xpath = "(//input[@Type='checkbox'])[1]")
	public WebElement checkbox1;
	
	@FindBy(xpath = "(//input[@Type='checkbox'])[2]")
	public WebElement checkbox2;
	
}
