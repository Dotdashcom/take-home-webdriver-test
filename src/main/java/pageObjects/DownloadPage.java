package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownloadPage {
	public WebDriver driver;
	
	By downloadLocator = By.xpath("//*[@id=\'content\']/div/a[1]"); ////*[@id="content"]/div/a[1]
	
	public DownloadPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getDownloadLocator()
	{
		return driver.findElement(downloadLocator);
	}

}
