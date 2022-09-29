package com.internet.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class CheckBoxesPage extends Page {
	private static final String PAGE_URL = "/checkboxes";

	public CheckBoxesPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By checkBox1 = By.cssSelector("#checkboxes input:first-of-type");
	private By checkBox2 = By.cssSelector("#checkboxes input:last-of-type");
	private By checkBoxes = By.cssSelector("#checkboxes input");

	public void selectCheckBox1() {
		((Proxywrapper) driver).click(checkBox1);
	}

	public void selectCheckBox2() {
		((Proxywrapper) driver).click(checkBox2);
	}

	public boolean isCheckBox1Selected() {
		return ((Proxywrapper) driver).isSelected(checkBox1);
	}

	public boolean isCheckBox2Selected() {
		return ((Proxywrapper) driver).isSelected(checkBox2);
	}

	public boolean isCheckBoxesSelected() {
		if (isCheckBox1Selected() && isCheckBox2Selected()) {
			return true;
		}
		return false;
	}

}
