package com.app.pages;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.util.PageLinks;

public class IFramePage extends BasePage {

	public IFramePage(WebDriver driver) {
		super(driver);
	}

	public void visitIFramePage() {
		getDriver().get(PageLinks.IFRAMES_PAGE);
	}

	public void verifyIFrame() {

		WebDriver driver = getDriver();
		driver.switchTo().frame("mce_0_ifr");
		WebElement placeHolder = driver.findElement(By.id("tinymce"));
		placeHolder.sendKeys("Some text here");
		String bodyText = driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText();
		assertTrue(bodyText.contains("Some text"));
	}
}
