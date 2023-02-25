package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CheckboxesPage;

public class Tc003_Checkboxes extends baseutils{

	baseutils bu =  new baseutils();

	@BeforeClass
	public void setup() {
		bu.initBrowser("/checkboxes");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void checkbox() throws IOException {
		CheckboxesPage cp = new CheckboxesPage(driver);
		boolean checkbox1status = cp.HandlingCheckbox1("checkbox 1");
		Assert.assertTrue(true,"assertion failed");
		logger.info("Assertion pass");
		
		boolean checkbox2status = cp.HandlingCheckbox2("checkbox 2");
		Assert.assertFalse(false,"assertion failed");
		logger.info("Assertion pass");
		bu.captureSrceenshot(driver, "checkbox");
		
	
	}
		
}
