package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC014_hoverObject{
	public WebDriver driver;
	By hoverLink = By.xpath("//a[text()='Hovers']");
	
	public By getImg(int a) {
		By imgHover = By.xpath("//div[@class='figure']["+a+"]");
		return imgHover;
	}
	
	public By userInfo(int a) {
		By imgHover = By.xpath("//div[@class='figure']["+a+"]/div");
		return imgHover;
	}
	
	////div[@class='figure'][1]/div
	//constructor for giving a life to the driver
	public TC014_hoverObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getHoverLink() {
		return driver.findElement(hoverLink);
	}
	
	public WebElement getHoverImage(int a) {
		return driver.findElement(getImg(a));
	}
	
	public WebElement gettUserInfo(int a) {
		return driver.findElement(userInfo(a));
	}
}
