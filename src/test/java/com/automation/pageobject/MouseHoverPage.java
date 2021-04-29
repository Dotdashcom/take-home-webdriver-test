package com.automation.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MouseHoverPage {
	public static final By MOUSEHOVERHEADER=By.xpath("//h3[text()='Hovers']");
	public static final By IMAGES=By.xpath("//div[@class='figure']/img");
	public static final By FIGCAPTION =By.xpath("//div[@class='figcaption']/h5");
	
	
	
	public static void validateMouseHovedrHeader(WebDriver driver) {
		WebElement element= driver.findElement(MOUSEHOVERHEADER);
		Assert.assertTrue(element.isDisplayed(), "Mouse Hover Header is not Displaying");
	}

	public static void MouseHover(WebDriver driver) throws InterruptedException {
		List<WebElement> element= driver.findElements(IMAGES);
		Actions action = new Actions(driver);

		for(int i=0;i<element.size();i++) {
			action.moveToElement(element.get(i)).perform();
			Thread.sleep(5000);
			Assert.assertEquals(driver.findElements(FIGCAPTION).get(i).getText(), "name: user"+(i+1));
			
		}
	}
}
