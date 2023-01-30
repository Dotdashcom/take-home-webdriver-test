package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import base.BaseTest;

public class FloatingMenuPage extends BaseTest{
	
	private By floatingMenu = By.cssSelector("div[id='menu']");

	public void floatingMenuDuringScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Assert.assertTrue(driver.findElement(floatingMenu).isDisplayed());
	}

}
