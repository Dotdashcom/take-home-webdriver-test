package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFramePage {
	
	public WebDriver driver;
	By iframeLocator = By.xpath("//*[@id=\'mce_0_ifr\']"); 
    By  frameBodyloc = By.xpath("//*[@id=\'tinymce\']");	
	public IFramePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement getIFrameLocator()
	{
		return driver.findElement(iframeLocator);
	}

	 public WebElement getFrameBodyLoc() {
		 return driver.findElement(frameBodyloc);
	 }
}
