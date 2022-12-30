package com.qa.INTest.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class CheckboxesPage extends TestBase {

	@FindBy(linkText = "Checkboxes")
	WebElement CheckboxesLink;

	@FindBy(xpath = "//input[@type='checkbox' and @checked = '']")
	WebElement checkedboxes;

	@FindBy(xpath = "//form[@id='checkboxes']/input[1]")
	WebElement unCheckedboxes;

	public CheckboxesPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnCheckboxesLink() {
		CheckboxesLink.click();

	}

	public int checkedboxes() {

		unCheckedboxes.click();
		List<WebElement> numberOfBoxes = driver.findElements(By.xpath("//input[@type='checkbox' and @checked = '']"));
		System.out.println("Number of checked boxes is: " + numberOfBoxes.size());
		if (numberOfBoxes.size() == 2) {
			System.out.println("Both the boxes are checked.");
		} else {
			System.out.println("One of the box is not checked");
		}

		return numberOfBoxes.size();

	}

	public int unCheckedboxes() {

		checkedboxes.click();
		List<WebElement> numberOfBoxes = driver.findElements(By.xpath("//input[@checked = '']"));
		System.out.println("Number of checked boxes is: " + numberOfBoxes.size());
		if (numberOfBoxes.size() == 0) {
			System.out.println("Both the boxes are unchecked.");
		} else {
			System.out.println("One of the box is checked");
		}

		return numberOfBoxes.size();

	}

}
