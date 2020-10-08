package com.dotdash.farhan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScrptAlertPage {
	public JavaScrptAlertPage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	
	@FindBy(xpath="//li[1]//button[1]")
	public static WebElement jsAlertBtn;

	@FindBy(xpath="//li[2]//button[1]")
	public static WebElement jsCOnfirmBtn;
	
	@FindBy(xpath="//li[3]//button[1]")
	public static WebElement jsPromptBtn;
	
	
	public WebElement jsAlertBtn() {
		return jsAlertBtn;
	}
	
	public WebElement jsCOnfirmBtn() {
		return jsCOnfirmBtn;
	}
	
	public WebElement jsPromptBtn() {
		return jsPromptBtn;
	}
	

	@FindBy(xpath ="//p[@id='result']")
	public static WebElement text;
	
	
	
	
	public WebElement text() {
		return text;
	}
}
