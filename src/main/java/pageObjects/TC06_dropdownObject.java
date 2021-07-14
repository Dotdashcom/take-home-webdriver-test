package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC06_dropdownObject{
	public WebDriver driver;
	By dropdownLink = By.xpath("//a[text()='Dropdown']");
	By dropdown = By.id("dropdown");
	By optionA = By.xpath("//option[@value='1']");
	By optionB = By.xpath("//option[@value='2']");
	
	//constructor for giving a life to the driver
	public TC06_dropdownObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getdropdownLink() {
		return driver.findElement(dropdownLink);
	}
	
	public WebElement getdropdown() {
		return driver.findElement(dropdown);
	}
	
	public WebElement getoptionA() {
		return driver.findElement(optionA);
	}
	
	public WebElement getoptionB() {
		return driver.findElement(optionB);
	}
}
