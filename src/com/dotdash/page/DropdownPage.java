package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/dropdown";
	private WebElement dropdown;

	public DropdownPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		verifyPage("Please select an option", null);
	}

	public void verifyPage(String selectedText, String selectedValue) {
		dropdown = driver.findElement(By.id("dropdown"));
		assertTrue(dropdown.isDisplayed());
		
		WebElement selected = new Select(dropdown).getFirstSelectedOption();
		assertEquals(selectedText, selected.getText());
		
		if (selectedValue != null) {
			assertEquals(selectedValue, selected.getAttribute("value"));
		}
	}
	
	public void selectByText(String text) {
		new Select(dropdown).selectByVisibleText(text);
	}
}
