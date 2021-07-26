package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotDash.qa.base.TestBase;

public class IframePage extends TestBase {

	// Finding the link to the Frames page
	@FindBy(xpath = "//a[@href='/frames']")
	WebElement frames;

	// Finding the iFrame element
	@FindBy(xpath = "//a[@href='/iframe']")
	WebElement iframes;

	// Finding the text box after switching to iFrames
	@FindBy(id = "tinymce")
	WebElement textbox;

	// Initializing the Page Objects:
	public IframePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// iFrame Test function
	public void iframe() {
		frames.click();
		iframes.click();
		driver.switchTo().frame("mce_0_ifr");
		textbox.sendKeys("Hello_World");

	}
}
