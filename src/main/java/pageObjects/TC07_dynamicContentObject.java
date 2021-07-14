package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC07_dynamicContentObject{
	public WebDriver driver;
	By dynamicContentLink = By.xpath("//a[text()='Dynamic Content']");
	
	public By contentImg(int a) {
		By contentImg = By.xpath("//div[@id='content']/div/div[@class='row']/div[@id='content']/div["+a+"]/div/img");
		return contentImg;
	}
	
	public By contentText(int a) {
		By contentText = By.xpath("//div[@id='content']/div/div[@class='row']/div[@id='content']/div["+a+"]/div[2]");
		return contentText;
	}
	
	
	
	//constructor for giving a life to the driver
	public TC07_dynamicContentObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getdynamicContentLink() {
		return driver.findElement(dynamicContentLink);
	}
	
	public WebElement getdynamicContentImg(int a) {
		return driver.findElement(contentImg(a));
	}
	
	public WebElement getdynamicContentText(int a) {
		return driver.findElement(contentText(a));
	}
	
}
