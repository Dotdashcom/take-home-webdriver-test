package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class ContextMenuPageElements extends CommonMethods {

	@FindBy(id = "hot-spot")
	public WebElement hotSpotBox;

	public ContextMenuPageElements() {
		PageFactory.initElements(driver, this);
	}

}
