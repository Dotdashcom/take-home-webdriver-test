package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class DynamicControlsTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/dynamic_controls");

	}

//	Test clicks on the Remove Button and uses explicit wait.
//	Test asserts that the checkbox is gone.
//	Test clicks on Add Button and uses explicit wait.
//	Test asserts that the checkbox is present.
//	Test clicks on the Enable Button and uses explicit wait.
//	Test asserts that the text box is enabled.
//	Test clicks on the Disable Button and uses explicit wait.
//	Test asserts that the text box is disabled.

	@Test
	public void removeDynamic() {

		WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input"));
		DriverUtility.clickonElement(removeButton);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(checkBox));
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText(), "It's gone!");

	}

	@Test
	public void addDynamic() {

		WebElement addButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		WebElement checkBoxA = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/div[1]"));
		DriverUtility.clickonElement(addButton);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(checkBoxA));
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText(), "It's back!");

	}

	@Test
	public void enableDynaimic() {

		WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		WebElement inputTextBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
		DriverUtility.clickonElement(enableButton);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(inputTextBox));

		Assert.assertTrue(!DriverUtility.isElementEnabled(inputTextBox));

	}

	@Test
	public void disableDynaimc() {

		WebElement disableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		WebElement inputTextBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
		DriverUtility.clickonElement(disableButton);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(inputTextBox));
		Assert.assertTrue(DriverUtility.isElementEnabled(inputTextBox));

	}

}
