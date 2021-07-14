package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC04_contextMenuObject{
	public WebDriver driver;
	By contextBoxLink = By.xpath("//a[text() = 'Context Menu']");
	By contextBox = By.xpath("//div[@id='hot-spot']");
	
	//constructor for giving a life to the driver
	public TC04_contextMenuObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getcontextBoxLink() {
		return driver.findElement(contextBoxLink);
	}
	
	public WebElement getContextBox() {
		return driver.findElement(contextBox);
	}
}
