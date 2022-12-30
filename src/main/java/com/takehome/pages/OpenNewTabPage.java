package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewTabPage {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/a")
	WebElement clickHereLink;
	
	@FindBy(xpath = "/html/body/div/h3")
	WebElement newWindowText;

	public OpenNewTabPage(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" + "windows";
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getClickHereLink()
	{
		return clickHereLink;	
	}
	
	public WebElement getNewWindowText()
	{
		return newWindowText;	
	}
	
	
}
