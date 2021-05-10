package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.dotdash.util.DriverUtil;

public class FloatingMenuPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/floating_menu";
	private WebElement menuItemHome;

	public FloatingMenuPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		menuItemHome = driver.findElement(By.cssSelector("a[href='#home']"));
		assertTrue(menuItemHome.isDisplayed());

		long yPos = DriverUtil.getElementYPositionOnViewport(driver, menuItemHome);
		assertTrue(yPos >= 0);

		long viewportHeight = DriverUtil.getViewportHeight(driver);
		assertTrue(yPos < viewportHeight - menuItemHome.getSize().getHeight());
	}
	
	public void scrollDownOnePage() {
		long offsetBefore = DriverUtil.getPageYOffset(driver);
		new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
		long offsetAfter = DriverUtil.getPageYOffset(driver);
		assertTrue(offsetAfter > offsetBefore);
	}
}
