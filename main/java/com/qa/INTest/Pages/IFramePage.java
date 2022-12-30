package com.qa.INTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class IFramePage extends TestBase {

	@FindBy(linkText = "Frames")
	WebElement frameLink;

	@FindBy(xpath = "//a[contains(text(),'iFrame')]")
	WebElement iFrameLink;

	@FindBy(xpath = "//iframe[@id='mce_0_ifr']")
	WebElement frameElement;

	@FindBy(id = "tinymce")
	WebElement body;

	public IFramePage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnIFrame() {
		frameLink.click();
		iFrameLink.click();

	}

	public String typeText() throws InterruptedException {

		driver.switchTo().frame("mce_0_ifr");
		return body.getText();

	}

}
