package com.dotDash.DotDash;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxFactory {

	public CheckBoxFactory(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	

	@FindBy(xpath = "//input[@type='checkbox']" )
	public static List<WebElement> allCheckBox;

	
	
	public List<WebElement> allCheckBox() {
		return allCheckBox;
	}

	
	
}
