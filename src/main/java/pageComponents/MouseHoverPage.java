package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MouseHoverPage
{
	WebDriver driver;
	public MouseHoverPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By firstPhotoElement = By.xpath("/html/body/div[2]/div/div/div[1]/img");
	By userName1Elemet = By.xpath("//h3[contains(text(),'name: user1')]");
	
	
	public WebElement getFirstPhoto()
	{
		return driver.findElement(firstPhotoElement);
	}
	
	public boolean isUserEnabled()
	{
		return driver.findElement(userName1Elemet).isDisplayed();
	}
}
