package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC016_jsErrorObject{
	public WebDriver driver;
	By alertLink = By.xpath("//a[text()='JavaScript onload event error']");
	public By alertButton(int a) {
		By btn = By.xpath("//ul/li["+a+"]/button");
		return btn;
	}
	
	//constructor for giving a life to the driver
	public TC016_jsErrorObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAlertLink() {
		return driver.findElement(alertLink);
	}
}
