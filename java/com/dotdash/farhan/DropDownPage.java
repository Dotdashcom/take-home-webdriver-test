package com.dotdash.farhan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DropDownPage {
	public DropDownPage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	

	@FindBy(xpath = "//select[@id='dropdown']" )
	public static WebElement dropdown;

	
	
	public WebElement dropdown() {
		return dropdown;
	}
}
