package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DragDropPage extends BasePage {
	WebDriver obj_Driver;
	String dragDropTitle = "//h3[text()='Drag and Drop']";
	String source = "//div[@id='column-a']";
	String destination = "//div[@id='column-b']";

	public DragDropPage(WebDriver driver) {
		super(driver);
		this.obj_Driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void isDisplayedPage() {
		explicitWait(dragDropTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(dragDropTitle)).size() > 0,
				"Drag and Drop  page is displayed");
	}

	public void dragDrop() {
		dragAndDrop(source, destination);
		Assert.assertTrue(obj_Driver.findElement(By.xpath(source)).getText().equalsIgnoreCase(destination),"No text displayed");
	}
}
