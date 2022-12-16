package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class OpenInNewTabPageElements extends CommonMethods{
	
	@FindBy(xpath = "//div[@id='content']/div/a")
	public static WebElement clickhere;
	
	@FindBy(xpath = "/html/body/div[1]/h3")
	public static WebElement newwindowtxt;

	public OpenInNewTabPageElements() {
		PageFactory.initElements(driver, this);
	}

}
