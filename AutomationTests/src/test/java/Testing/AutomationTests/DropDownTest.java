package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.DropDownPage;
import resources.base;

public class DropDownTest extends base {

		public WebDriver driver;
		DropDownPage dropdown;


		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("dropdownUrl"));

		}


		@Test
		public void dropDownOption1() {
			dropdown = new DropDownPage(driver);
			dropdown.selectOption1();
			String selectedOption=dropdown.isOptionSelected();
			AssertJUnit.assertEquals(selectedOption, "Option 1");

			//Selecting Option 2 in same test flow
			dropdown.selectOption2();
			selectedOption=dropdown.isOptionSelected();
			AssertJUnit.assertEquals(selectedOption, "Option 2");
		}

		@Test
		public void dropDownOption2() {
			dropdown = new DropDownPage(driver);
			dropdown.selectOption2();
			String selectedOption=dropdown.isOptionSelected();
			AssertJUnit.assertEquals(selectedOption, "Option 2");

		}

		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}



	}

