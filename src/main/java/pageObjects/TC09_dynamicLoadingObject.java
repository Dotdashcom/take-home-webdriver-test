package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC09_dynamicLoadingObject{
	public WebDriver driver;
	By dynamicLoadingLink = By.xpath("//a[text()='Dynamic Loading']");
	By exampleLink = By.xpath("//div[@class='example']/a[1]");
	By exampleButton = By.xpath("//div[@id='start']/button");
	//constructor for giving a life to the driver
	public TC09_dynamicLoadingObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getDynamicLoadingLink() {
		return driver.findElement(dynamicLoadingLink);
	}
	
	public WebElement getExampleLink() {
		return driver.findElement(exampleLink);
	}
	
	public WebElement getExampleButton() {
		return driver.findElement(exampleButton);
	}
}
