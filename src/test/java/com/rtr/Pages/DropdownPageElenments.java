package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rtr.utils.CommonMethods;

public class DropdownPageElenments extends CommonMethods {

	@FindBy(id = "dropdown")
	public static WebElement dpdown;

	public DropdownPageElenments() {
		PageFactory.initElements(driver, this);
	}

}
