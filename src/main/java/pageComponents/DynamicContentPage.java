package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicContentPage
{
	WebDriver driver;
	public DynamicContentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By clickHereLink = By.xpath("//a[contains(text(),'click here')]");
	By onlyChangingPara = By.xpath("//*[@id=\"content\"]/div[3]/div[2]");
	
	public String getChangingPara()
	{
		return driver.findElement(onlyChangingPara).getText();
	}
	public void clickTheLink()
	{
		driver.findElement(clickHereLink).click();
	}
}
