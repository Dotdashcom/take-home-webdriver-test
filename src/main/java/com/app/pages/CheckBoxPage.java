package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.util.PageLinks;

public class CheckBoxPage extends BasePage{

	public CheckBoxPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//form/input)[1]")
	private WebElement checkBoxOne;
	
	@FindBy(xpath = "(//form/input)[2]")
	private WebElement checkBoxTwo;
	
	public void verifyCheckBoxOne() throws InterruptedException {
		boolean notChecked = !checkBoxOne.isSelected();
		assertTrue(notChecked);
		Thread.sleep(500);
		checkBoxOne.click();
		boolean checked = checkBoxOne.isSelected();
		assertTrue(checked);
		Thread.sleep(500);
		checkBoxOne.click();
		Thread.sleep(500);
		assertNotEquals("", "df");
	}
	
	public void verifyCheckBoxTwo() throws InterruptedException {
		boolean checked = checkBoxTwo.isSelected();
		assertTrue(checked);
		Thread.sleep(500);
		checkBoxTwo.click();
		boolean notChecked = !checkBoxTwo.isSelected();
		assertTrue(notChecked);
		Thread.sleep(500);
		checkBoxTwo.click();
		Thread.sleep(500);
	}
	
	
	public void visitCheckBoxPage() {
		getDriver().get(PageLinks.CHECKBOX_PAGE);
	}
}
