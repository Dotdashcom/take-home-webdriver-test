package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import pageObj.CheckBoxesPageObj;

public class ChechBoxesTest extends Base {

	CheckBoxesPageObj CheckBoxPage;

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/checkboxes");
	}

	// Test checks and unchecks checkboxes.
	// Test uses assertions to make sure boxes were properly checked and unchecked.

	@Test
	public void verifyCheckBox() {
//		WebElement box1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
//		WebElement box2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

		if (!CheckBoxPage.Box1Selected()) {
			CheckBoxPage.clickBox1();
		} else {
			System.out.println("Box 1 is selected already!");
		}

		CheckBoxPage.clickBox1();

		if (!CheckBoxPage.Box2Selected()) {
			CheckBoxPage.clickBox2();
		} else {
			System.out.println("Box 2 is selected");
		}
		CheckBoxPage.clickBox2();

		Assert.assertTrue(CheckBoxPage.Box1Selected());
		Assert.assertTrue(CheckBoxPage.Box2Selected());

	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}
}
