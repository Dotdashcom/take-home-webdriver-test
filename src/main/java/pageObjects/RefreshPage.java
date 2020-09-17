package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RefreshPage {
	
	public WebDriver driver;
	By refreshContentLoc = By.xpath("//*[@id=\'content\']/div[3]/div[2]");
	
	public RefreshPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public WebElement getRefreshContentLoc()
	{
		return driver.findElement(refreshContentLoc);
	}
}
