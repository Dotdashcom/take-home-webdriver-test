package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDrop_page
{
	WebDriver driver;
	
	public DragAndDrop_page(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath="//*[@id='column-a']")
	public WebElement Square_A;
	@FindBy(xpath="//*[@id='column-b']")
	public WebElement Square_B;

}
