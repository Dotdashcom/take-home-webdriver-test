package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class FloatingMenuPage {
	static WebDriver driver;

	public FloatingMenuPage(WebDriver driver) {
		FloatingMenuPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//div[@id = 'menu']")
	WebElement FLOATING_MENU_ELEMENT;

//	Methods
	public void scrollPageDown() {
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		scroll.executeScript("scroll(0, 2000)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateFloatingMenuIsPresentAfterScrollingDown() {
		Assert.assertTrue(FLOATING_MENU_ELEMENT.isDisplayed(), "Floating menu is not present after scrolling down!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
