package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/checkboxes";
	private List<WebElement> checkboxes;

	public CheckboxesPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		verifyPage(new boolean[] {false, true});
	}
	
	public void verifyPage(boolean[] checked) {
		checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		assertEquals(checkboxes.size(), checked.length);
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			assertTrue(checkbox.isDisplayed());
			assertEquals(checkbox.isSelected(), checked[i]);
		}
	}
	
	public void clickAllCheckboxes() {
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			checkbox.click();
		}
	}
}
