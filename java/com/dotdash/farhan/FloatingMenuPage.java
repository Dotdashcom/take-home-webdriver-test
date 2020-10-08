package com.dotdash.farhan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FloatingMenuPage {
	public FloatingMenuPage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}
	
	@FindBy(xpath = "//li[1]//a[1]" )
	public static WebElement homeBtn;
	
	@FindBy(xpath = "//li[2]//a[1]" )
	public static WebElement newsBtn;
	
	@FindBy(xpath = "//li[3]//a[1]" )
	public static WebElement contactBtn;
	
	@FindBy(xpath = "//li[4]//a[1]" )
	public static WebElement aboutBtn;
	
	
	public WebElement homeBtn() {
		return homeBtn;
	}
	public WebElement newsBtn() {
		return newsBtn;
	}
	public WebElement contactBtn() {
		return contactBtn;
	}
	public WebElement aboutBtn() {
		return aboutBtn;
	}
}
