package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DynamicControlPage extends BasePage {

	WebDriver obj_Driver;
	String dynamicControlTitle = "//h3[text()='Dynamic Controls']";
	String removeButton = "//button[contains(text(),'Remove')]";
	String removeMessage = "//p[contains(text(),'gone')]";
	String addButton = "//button[contains(text(),'Add')]";
	String addMessage = "//p[contains(text(),'back')]";
	String diasableButton = "//button[contains(text(),'Disable')]";
	String disabledMessage = "//p[contains(text(),'disabled')]";
	String enableButton = "//button[contains(text(),'Enable')]";
	String enableMessage = "//p[contains(text(),'enabled')]";
	String checkbox = "//input[@type='checkbox']";
	String textbox = "//input[@type='text']";

	public DynamicControlPage(WebDriver driver) {
		super(driver);
		obj_Driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void isDisplayedPage() {
		explicitWait(dynamicControlTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(dynamicControlTitle)).size() > 0,
				"dynamic Control page is displayed");
	}

	public void verifyDynamicCtrl() {
		click(removeButton, "Remove Button");
		explicitWait(removeMessage);
		Assert.assertTrue((obj_Driver.findElements(By.xpath(checkbox)).size() == 0), "Checkbox is not displayed");
		click(addButton, "Add Button");
		explicitWait(addMessage);
		Assert.assertTrue((obj_Driver.findElements(By.xpath(checkbox)).size() > 0), "Checkbox is displayed");
		click(enableButton, "Enable Button");
		explicitWait(enableMessage);
		System.out.println("att " + obj_Driver.findElement(By.xpath(textbox)).isEnabled());
		System.out.println("att " + obj_Driver.findElement(By.xpath(textbox)).getAttribute("draggable"));
		Assert.assertTrue((obj_Driver.findElement(By.xpath(textbox)).isEnabled()), "Textbox is enabled");

		click(diasableButton, "Disable Button");
		explicitWait(disabledMessage);
		Assert.assertTrue((!obj_Driver.findElement(By.xpath(textbox)).isEnabled()), "Textbox is disabled");
	}

}
