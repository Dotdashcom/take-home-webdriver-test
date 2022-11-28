package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class DragDropTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("dragDropURL"));
	}

	@Test(priority = 2)
	public void dragDropTest() throws Exception {
		WebElement fromColumnA = driver.findElement(By.xpath("//*[@id='column-a']"));
		// Element(DEBIT SIDE) on which need to drop.
		WebElement toColumnB = driver.findElement(By.xpath("//*[@id='column-b']"));
		Actions builder = new Actions(driver);
		//Building a drag and drop action
	    builder.clickAndHold(fromColumnA).moveToElement(toColumnB).build();
	    builder.dragAndDrop(fromColumnA, toColumnB).perform();
		//Performing the drag and drop action
	    //wait
		Thread.sleep(5000);
		String textColumnA = fromColumnA.getText();
		Assert.assertEquals(textColumnA, "B");
		
	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
