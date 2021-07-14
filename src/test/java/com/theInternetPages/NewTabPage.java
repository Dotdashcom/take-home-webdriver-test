package com.theInternetPages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class NewTabPage extends BasePage {

	WebDriver obj_Driver;
	String pagetitle = "//h3[text()='Opening a new window']";
	String clickHereLink = "//a[contains(text(),'Click Here')]";
	String newWindowTitle = "//h3[text()='New Window']";

	public NewTabPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.obj_Driver = driver;

	}

	public void isDisplayedPage() {
		explicitWait(pagetitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(pagetitle)).size() > 0, "New Tab page is displayed");
	}

	public void clickHere() {

		click(clickHereLink, "Click Here");

	}

	public void verifyChildWindow() {
		String parentWindow = obj_Driver.getWindowHandle();
		Set<String> allWindows = obj_Driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equalsIgnoreCase(parentWindow)) {
				obj_Driver.switchTo().window(window);
				break;

			}

		}
		Assert.assertTrue(obj_Driver.findElements(By.xpath(newWindowTitle)).size() == 1,
				"Could not switch to child window");
		Reporter.log("Switched to new window Successfully");
	}

}
