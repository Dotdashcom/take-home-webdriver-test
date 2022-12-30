package com.qa.INTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.INTest.TestBase.TestBase;

public class DropDownPage extends TestBase {

	@FindBy(linkText = "Dropdown")
	WebElement dropDown;

	@FindBy(xpath = "//select[@id='dropdown']")
	WebElement dropDownMenu;

	public DropDownPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickDropDownLink() {
		dropDown.click();

	}

	public String selectOption1() {

		Select s1 = new Select(dropDownMenu);
		s1.selectByVisibleText("Option 1");
		System.out.println(s1.getFirstSelectedOption().getText());
		System.out.println("<------------Second Selction--------->");
		
		Select s2 = new Select(dropDownMenu);
		s2.selectByVisibleText("Option 2");
		System.out.println(s2.getFirstSelectedOption().getText());
		return s2.getFirstSelectedOption().getText();

	}

}
