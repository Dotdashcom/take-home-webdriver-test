package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContextMenuPage extends BasePage {

	WebDriver obj_Driver;
	String contextMenu = "//div[@id='hot-spot']";
	String contextTitle = "//h3[text()='Context Menu']";

	public ContextMenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.obj_Driver = driver;
	}

	public void isDisplayedPage() {
		explicitWait(contextTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(contextTitle)).size() > 0, "Context Menu page is displayed");
	}

	public void rightClick() throws InterruptedException {
		rightClick(contextMenu);

	}

	public void alertAcpt() {
		alertAcceptWithVerifyText("You selected a context menu");

	}

}
