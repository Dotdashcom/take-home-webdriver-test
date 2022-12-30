package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControls {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"checkbox-example\"]/button")WebElement addRemoveButton;
	@FindBy(id = "checkbox")WebElement checkbox;
	@FindBy(id = "message") WebElement message;
	@FindBy(xpath="//*[@id=\"input-example\"]/button") WebElement enableDisableButton;
	@FindBy(xpath="//*[@id=\"input-example\"]/input") WebElement inputBox;
	

	public DynamicControls(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" +"dynamic_controls";
		driver.get(url);
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getAddRemoveButton() {
		return addRemoveButton;
	}


	public WebElement getCheckbox() {
		return checkbox;
	}


	public WebElement getEnableDisableButton() {
		return enableDisableButton;
	}


	public WebElement getInputBox() {
		return inputBox;
	}

	public WebElement getMessage()
	{
		return message;
	}
	
	
}
