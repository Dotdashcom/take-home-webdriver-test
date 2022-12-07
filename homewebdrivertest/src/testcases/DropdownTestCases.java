package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DropdownPage;

public class DropdownTestCases {

private WebDriver browser;
	
	private DropdownPage dropdownPage;
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		dropdownPage = new DropdownPage(browser);
		browser.manage().window().maximize();
		dropdownPage.goToPage();
		dropdownPage.getOptions();
	}
	
	@Test
	public void select_each_all_dropdown_options() {
		int amountOptions = dropdownPage.getDropdownOptions().size();
		String toSelectOption,currentSelectedOption;

		for (int i = 1; i < amountOptions; i++) {
			WebElement option = dropdownPage.getDropdownOptions().get(i);
			option.click();
			toSelectOption = option.getText();
			currentSelectedOption = dropdownPage.getSelectedOptions().getText();

			assertEquals(currentSelectedOption, toSelectOption);
		}
	}
	
	@AfterEach
	public void exit() {
		browser.quit();
	}
	
}
