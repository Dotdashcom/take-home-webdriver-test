package com.qa.INTest.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class FloatingMenuPage extends TestBase {

	@FindBy(linkText = "Floating Menu")
	WebElement floatMenuLink;

	@FindBy(xpath = "//a[@target='_blank']")
	WebElement footer;
	public FloatingMenuPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnFloatingMenu() {
		floatMenuLink.click();

	}

	public boolean scorllThePage() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,5000)");
		
		return footer.isDisplayed();
		

	}
}
