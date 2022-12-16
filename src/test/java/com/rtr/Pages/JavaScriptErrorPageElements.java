package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class JavaScriptErrorPageElements extends CommonMethods{

	@FindBy(css = "#flash")
	public static WebElement msg;

	public JavaScriptErrorPageElements() {
		PageFactory.initElements(driver, this);
	}
}
