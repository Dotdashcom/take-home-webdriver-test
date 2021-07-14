package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC12_floatingMenuObject{
	public WebDriver driver;
	By floatingMenuLink = By.xpath("//a[text()='Floating Menu']");
	By menu = By.xpath("//div[@id='menu']");
	
	//constructor for giving a life to the driver
	public TC12_floatingMenuObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getFloatingMenuLink() {
		return driver.findElement(floatingMenuLink);
	}
	
	public WebElement getFloatingMenu() {
		return driver.findElement(menu);
	}
}
