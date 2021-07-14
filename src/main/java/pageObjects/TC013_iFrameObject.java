package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC013_iFrameObject{
	public WebDriver driver;
	By iFrameLink = By.xpath("//a[text()='Frames']");
	By frameLink = By.xpath("//div[@class='example']/ul/li[2]/a");
	By frameId = By.xpath("//iframe");
	By frameBody = By.xpath("html/body[@id='tinymce']");
	//constructor for giving a life to the driver
	public TC013_iFrameObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getIFrameLink() {
		return driver.findElement(iFrameLink);
	}
	
	public WebElement getFrameLink() {
		return driver.findElement(frameLink);
	}
	
	public WebElement getFrameId() {
		return driver.findElement(frameId);
	}
	
	public WebElement getFrameBody() {
		return driver.findElement(frameBody);
	}
}
