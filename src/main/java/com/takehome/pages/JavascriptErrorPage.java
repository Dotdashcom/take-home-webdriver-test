package com.takehome.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptErrorPage {
	
	WebDriver driver;

	
	@FindBy(xpath = "/html/body/p")
	WebElement errorDisplay;

	public JavascriptErrorPage(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" + "javascript_error";
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getErrorDisplay()
	{
		return errorDisplay;
	}
}
