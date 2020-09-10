package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePageElements extends BaseClass {

	// location of iFrame
	@FindBy(css = "iframe[id*='ifr']")
	public WebElement iFrame;

	@FindBy(xpath = "//body[@id='tinymce']")
	public WebElement contentBody;

	public IFramePageElements() {
		PageFactory.initElements(driver, this);
	}

}
