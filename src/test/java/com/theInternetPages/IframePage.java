package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IframePage extends BasePage {

	WebDriver obj_Driver;
	String iFrameTitle = "//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']";
	String iframeid = "//iframe[@id='mce_0_ifr']";
	String enterText = "//p | //textarea";
	String textToEnter = "Hello";

	public IframePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.obj_Driver = driver;
	}

	public void isDisplayedPage() {
		explicitWait(iFrameTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(iFrameTitle)).size() > 0, "IFrame page is displayed");
	}

	public void iFrame() throws InterruptedException {
		if (obj_Driver.findElements(By.xpath(iframeid)).size() > 0)
			obj_Driver.switchTo().frame(obj_Driver.findElement(By.xpath(iframeid)));
		setValue(enterText, textToEnter, "Text Area");
		click(iFrameTitle, "Title");
		Thread.sleep(3000);
		Assert.assertTrue(obj_Driver.findElement(By.xpath(enterText)).getText().equalsIgnoreCase(textToEnter),
				"Entered text does not match with expected text");

	}

}
