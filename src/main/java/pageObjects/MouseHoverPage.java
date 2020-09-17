package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MouseHoverPage {

	
	public WebDriver driver;
	
	By avatar1Loc = By.xpath("//*[@id=\'content\']/div/div[1]/img");
	By avatar2Loc = By.xpath("//*[@id=\'content\']/div/div[2]/img");
	By avata3Loc = By.xpath("//*[@id=\'content\']/div/div[3]/img");
	
	public MouseHoverPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getAvatar1Loc()
	{
		return driver.findElement(avatar1Loc);
	}
	
	public WebElement getAvata2Loc()
	{
		return driver.findElement(avatar2Loc);
	}

    public WebElement getAvatar3Loc()
    {
    	return driver.findElement(avata3Loc);
    }
}
