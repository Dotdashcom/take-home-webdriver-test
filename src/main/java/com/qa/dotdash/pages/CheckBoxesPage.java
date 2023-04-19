package com.qa.dotdash.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.dotdash.utils.Proxywrapper;

public class CheckBoxesPage extends Page {
	private static final String PAGE_URL = "/checkboxes";

	public CheckBoxesPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By checkBox1 = By.cssSelector("#checkboxes input:first-of-type");
	private By checkBox2 = By.cssSelector("#checkboxes input:last-of-type");
	

	public void clickCheckBox1() {
		((Proxywrapper) driver).click(checkBox1);
	}

	public void clickCheckBox2() {
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
