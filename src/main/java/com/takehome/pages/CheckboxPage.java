package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {

	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
	WebElement checkbox1;
	@FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
	WebElement checkbox2;

	public CheckboxPage(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" + "checkboxes";
		driver.get(url);
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	public WebElement getCheckBox1()
	{
		return checkbox1;
	}
	
	

	public WebElement getCheckBox2()
	{
		return checkbox2;
	}
	
	
}
