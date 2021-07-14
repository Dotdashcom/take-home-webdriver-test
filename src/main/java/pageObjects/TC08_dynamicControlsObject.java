package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC08_dynamicControlsObject{
	public WebDriver driver;
	By dynamicControlsLink = By.xpath("//a[text()='Dynamic Controls']");
	By checkbox1 = By.xpath("//div[@id='checkbox']");
	By button = By.xpath("//form[@id='checkbox-example']/button");
	By textMsg = By.xpath("//form[@id='checkbox-example']/p");
	By checkbox2 = By.xpath("//form[@id='checkbox-example']/div[1]");
	By enableButton = By.xpath("//form[@id='input-example']/button");
	By enableInput = By.xpath("//form[@id='input-example']/input");
	
	//constructor for giving a life to the driver
	public TC08_dynamicControlsObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getDynamicControlsLink() {
		return driver.findElement(dynamicControlsLink);
	}
	
	public WebElement getCheckbox1() {
		return driver.findElement(checkbox1);
	}
	
	public WebElement getButton() {
		return driver.findElement(button);
	}
	
	public WebElement getTextMsg() {
		return driver.findElement(textMsg);
	}
	
	public WebElement getCheckbox2() {
		return driver.findElement(checkbox2);
	}
	
	public WebElement getEnableButton() {
		return driver.findElement(enableButton);
	}
	
	public WebElement getEnableInput() {
		return driver.findElement(enableInput);
	}
	
}
