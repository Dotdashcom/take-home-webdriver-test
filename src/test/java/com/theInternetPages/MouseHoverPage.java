package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class MouseHoverPage extends BasePage {

	WebDriver obj_Driver;
	String pagetitle = "//h3[text()='Hovers']";
	String user1 = "(//div[@class='figure'])[1]";
	String user2 = "(//div[@class='figure'])[2]";
	String user3 = "(//div[@class='figure'])[3]";

	public MouseHoverPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.obj_Driver = driver;
	}

	public void isDisplayedPage() {
		explicitWait(pagetitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(pagetitle)).size() > 0, "Mouse hover page is displayed");
	}

public void mouseHover() {
	mouseHover(user1);
	isDisplayedAssert(user1, "Mouse hovered on user1");
	Reporter.log("Mouse hovered on user1");
	mouseHover(user2);
	isDisplayedAssert(user2, "Mouse hovered on user2");
	Reporter.log("Mouse hovered on user2");
	mouseHover(user3);
	isDisplayedAssert(user2, "Mouse hovered on user3");
	Reporter.log("Mouse hovered on user3");
	
}

}
