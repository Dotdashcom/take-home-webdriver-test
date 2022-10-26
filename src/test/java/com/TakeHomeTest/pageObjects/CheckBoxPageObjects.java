package com.TakeHomeTest.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPageObjects {
	WebDriver ldriver;

	public CheckBoxPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}

	@FindBy(xpath="//form//input")
	public List<WebElement>  checkboxes;

}
