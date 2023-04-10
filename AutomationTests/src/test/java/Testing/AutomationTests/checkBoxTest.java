package Testing.AutomationTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import pageobjects.CheckBoxPage;
import resources.base;

public class checkBoxTest extends base {

		public WebDriver driver;
		CheckBoxPage checkbox; 

@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("checkboxesUrl"));

		}


		@Test
		public void validateCheckboxes() throws IOException, InterruptedException {	
			checkbox = new CheckBoxPage(driver);
			//selecting and Unselecting the CheckBox 1 
			AssertJUnit.assertFalse(checkbox.getCheckbox1().isSelected());
			checkbox.getCheckbox1().click();
			System.out.println("CheckBox 1 is selected");
			AssertJUnit.assertTrue(checkbox.getCheckbox1().isSelected());
			//Unselecting and selecting the CheckBox 2 
			AssertJUnit.assertTrue(checkbox.getCheckbox2().isSelected());
			checkbox.getCheckbox2().click();
			System.out.println("CheckBox 2 is unselected");
			AssertJUnit.assertFalse(checkbox.getCheckbox2().isSelected());
	
		}


		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}



	}

