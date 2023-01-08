package com.theInternet.qa.pages;

import java.util.List;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxesPage {

	WebDriver driver;

	@FindBy(xpath = ("//form[@id='checkboxes']"))
	List<WebElement> checkBoxes_List;

	public CheckBoxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyCheckboxesSelection() throws InterruptedException {

		for (WebElement element : checkBoxes_List) {
			if (!element.isSelected()) {
				element.click();
				Thread.sleep(2000);
			}
			Assert.assertTrue(element.isSelected(), "check and uncheck working properly");
		}

	}

}
