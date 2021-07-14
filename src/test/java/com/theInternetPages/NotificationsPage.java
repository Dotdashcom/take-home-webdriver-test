package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class NotificationsPage extends BasePage {

	WebDriver obj_Driver;
	String title = "//h3[text()='Notification Message']";
	String clickNotification = "//a[text()='Click here']";
	String actualText = "//div[@id='flash']";
	String unsuccessfulMsg = "//div[contains(text(),'Action unsuccessful, please try again')]";
	String[] textList = { "Action successful", "Action unsuccesful, please try again" };

	public NotificationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.obj_Driver = driver;
	}

	public void isDisplayedPage() {
		explicitWait(title);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(title)).size() > 0, "Notification page is displayed");
	}

	public void notificationClick() throws InterruptedException {
		boolean msgFlag = false;
		click(clickNotification, "Click Here");
		explicitWait(actualText);
		for (String text : textList) {
			if ((obj_Driver.findElement(By.xpath(actualText)).getText().trim().contains(text.trim()))) {
				msgFlag = true;
				break;
			}
		}
		if (msgFlag) {
			Reporter.log("Message is displayed");
		} else
			Assert.assertTrue(false, "Message is not displayed");

	}

}
