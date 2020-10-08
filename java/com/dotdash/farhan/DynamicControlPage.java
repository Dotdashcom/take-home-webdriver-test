package com.dotdash.farhan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DynamicControlPage {
	public DynamicControlPage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	
	@FindBy(xpath="//form[@id='checkbox-example']//button")
	public static WebElement removeBtn;

	@FindBy(xpath="//form[@id='input-example']//button")
	public static WebElement inputBoxBtn;

	public WebElement removeBtn() {
		return removeBtn;
	}
	public WebElement inputBoxBtn() {
		return inputBoxBtn;
	}
	
	@FindBy(xpath = "//p[@id='message']")
	public static WebElement text;
	
	public WebElement text() {
		return text;
	}
}
