package com.dotdash.farhan;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class NotificationPage {
	public NotificationPage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	

	@FindBy(xpath = "//div[@class='example']//p//a" )
	public static WebElement newMessageBtn;
	
	@FindBy(xpath="//div[@id='flash']")
	public static WebElement notificationMessage;

	
	
	public WebElement newMessageBtn() {
		return newMessageBtn;
	}
	
	public WebElement notificationMessage() {
		return notificationMessage;
	}
}