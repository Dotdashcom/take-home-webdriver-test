package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import pageObj.MouseHoverPageObj;
import utilities.DriverUtility;

public class MouseHoverTest extends Base {

	MouseHoverPageObj HoverPageObj;

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/hovers");
	}

	// Test does a mouse hover on each image.
	// Test asserts that additional information is displayed for each image.

	@Test
	public void MouseHover() throws InterruptedException {

		HoverPageObj.HoverfigureOne();
		DriverUtility.wait(1000);
		Assert.assertTrue(HoverPageObj.userOneDisplayd());

		HoverPageObj.HoverfigureTwo();
		DriverUtility.wait(1000);
		Assert.assertTrue(HoverPageObj.userTwoDisplayd());

		HoverPageObj.HoverfigureThree();
		DriverUtility.wait(1000);
		Assert.assertTrue(HoverPageObj.userThreeDisplayd());

	}

	@AfterMethod
	public void aftermethod() {

		// driver.quit();

	}

}
