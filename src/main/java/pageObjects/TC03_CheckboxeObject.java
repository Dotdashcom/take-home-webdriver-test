package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC03_CheckboxeObject{
	public WebDriver driver;
	By checkboxLink = By.xpath("//a[text() = 'Checkboxes']");
	By checkbox1 = By.xpath("//input[@type='checkbox'][1]");
	By checkbox2 = By.xpath("//input[@type='checkbox'][2]");
	
	//constructor for giving a life to the driver
	public TC03_CheckboxeObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getcheckboxLink() {
		return driver.findElement(checkboxLink);
	}
	
	public WebElement getcheckbox1() {
		return driver.findElement(checkbox1);
	}
	
	public WebElement getcheckbox2() {
		return driver.findElement(checkbox2);
	}
	
	
}
