package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.DynamicLoading;

public class DynamicLoadingTest extends BaseTest {

	public DynamicLoadingTest() {
		PageFactory.initElements(driver, this);
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("dynamicloadingurl"));
		Thread.sleep(1000);
		dynamicloading = new DynamicLoading();
	}
	
	DynamicLoading dynamicloading;
	
	@Test
	public void startbuttontest() {
		dynamicloading.start();
	}
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
}
