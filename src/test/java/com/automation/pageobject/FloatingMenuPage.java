package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FloatingMenuPage {

	public static final By FLOATINGMENUEADER=By.xpath("//h3[text()='Floating Menu']");
	public static final By HOME_MENU = By.xpath("//a[text()='Home']");
	public static final By PARA2 = By.xpath("//div[@class='scroll large-10 columns large-centered']/p[2]");
	
	
	public static void validateFloatingMenuHeader(WebDriver driver) {
		WebElement element= driver.findElement(FLOATINGMENUEADER);
		Assert.assertTrue(element.isDisplayed(), "FloatingMenu Header is not Displaying");
	}
	
	public static void scrollAndValidateFloatingMenus(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
     		
        WebElement Element = driver.findElement(PARA2);
		
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Assert.assertTrue(driver.findElement(PARA2).isDisplayed(), "Home menu is not displayed");
	}

}
