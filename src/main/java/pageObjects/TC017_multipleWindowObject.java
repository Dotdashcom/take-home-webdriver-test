package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC017_multipleWindowObject{
	public WebDriver driver;
	By windowLink = By.xpath("//a[text()='JavaScript Alerts']");
	By window1Link = By.xpath("//div[@class='example']/a");
	By window2Text = By.xpath("//div/h3");
	
	//constructor for giving a life to the driver
	public TC017_multipleWindowObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getWindowLink() {
		return driver.findElement(windowLink);
	}
	
	public WebElement getWindow1Link() {
		return driver.findElement(window1Link);
	}
	
	public WebElement getWindow2Text() {
		return driver.findElement(window2Text);
	}
	
}
