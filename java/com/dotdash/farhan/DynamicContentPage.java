package com.dotdash.farhan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DynamicContentPage {
	public DynamicContentPage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	
	@FindBy(xpath="//div[@class='example']//div[@id='content']")
	public static WebElement contentText;

	
	public WebElement contentText() {
		return contentText;
	}
}
