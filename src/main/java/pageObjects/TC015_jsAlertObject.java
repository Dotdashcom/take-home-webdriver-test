package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC015_jsAlertObject{
	public WebDriver driver;
	By alertLink = By.xpath("//a[text()='JavaScript Alerts']");
	public By alertButton(int a) {
		By btn = By.xpath("//ul/li["+a+"]/button");
		return btn;
	}
	By resultText = By.xpath("//p[@id='result']");
	//constructor for giving a life to the driver
	public TC015_jsAlertObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAlertLink() {
		return driver.findElement(alertLink);
	}
	
	public WebElement getAlertButton(int a) {
		return driver.findElement(alertButton(a));
	}
	
	public WebElement getResultText() {
		return driver.findElement(resultText);
	}
}
