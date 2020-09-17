package com.POM;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPage {
	WebDriver driver;


	public DropDownPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "dropdown")
	WebElement dropDown;



	public String dropdown(){
		WebElement we;
		Select select = new Select(dropDown);
		select.selectByVisibleText("Option 1");

		we = select.getFirstSelectedOption();
		String text = we.getText();
		return text;
	}
}