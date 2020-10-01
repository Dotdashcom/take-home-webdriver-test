package com.dotDash.DotDash;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DynamicLoadingPage {

	public DynamicLoadingPage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	
	@FindBy(xpath="//div[@id='start']//button")
	public static WebElement startBtn;

	@FindBy(xpath="//div[@id='finish']//h4")
	public static WebElement text;
	
	public WebElement startBtn() {
		return startBtn;
	}
	
	public WebElement text() {
		return text;
	}
	
}

