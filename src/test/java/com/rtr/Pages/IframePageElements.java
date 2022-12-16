package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class IframePageElements extends CommonMethods {

	@FindBy (css = "#mce_0_ifr")
	public WebElement frame1;

	@FindBy (css = "#tinymce")
	public WebElement txtContent;
	
	public IframePageElements() {
		PageFactory.initElements(driver, this);
	}
}
