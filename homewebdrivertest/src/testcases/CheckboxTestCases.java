package testcases;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CheckboxPage;


public class CheckboxTestCases {
	
	private WebDriver browser;
	
	private CheckboxPage checkboxPage;
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		checkboxPage = new CheckboxPage(browser);
		browser.manage().window().maximize();
		checkboxPage.goToPage();
		checkboxPage.getCheckboxes();
	}
	
	@Test
	public void all_checkboxes_checked() {
		checkboxPage.checkAllCheckboxes();
		assertTrue(checkboxPage.isAllCheckboxesChecked(), "Not every checkbox are checked.");;
	}

	@Test
	public void all_checkboxes_unchecked() {
		checkboxPage.uncheckAllCheckboxes();
		assertTrue(checkboxPage.isAllCheckboxesUnchecked(), "Not every checkbox are unchecked.");
	}

	@AfterEach
	public void exit() {
		browser.quit();
	}

}
