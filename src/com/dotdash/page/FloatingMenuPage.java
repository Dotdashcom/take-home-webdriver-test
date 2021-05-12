package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public void scrollDown(int pixels) {
		long offsetBefore = DriverUtil.getPageYOffset(driver);
		// Passed on my side, failed on dotdash's side
		// new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
		
		final String js = String.format("window.scrollBy(0,%d)", pixels);
		((JavascriptExecutor) driver).executeScript(js);

		long offsetAfter = DriverUtil.getPageYOffset(driver);
		assertTrue(offsetAfter > offsetBefore);
	}
}
