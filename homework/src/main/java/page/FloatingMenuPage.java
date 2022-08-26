package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FloatingMenuPage {

	WebDriver driver;

	public FloatingMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Floating Menu')]")
	WebElement FLOATING_MENU_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id='content']")
	WebElement FLOATING_MENU;

	public void floatingMenu() {
		FLOATING_MENU_ELEMENT.click();
	}

	public void floatingElement() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scroll down
		Thread.sleep(1000);
		js.executeScript("window.scroll(0, 7000)");
		Thread.sleep(2000);

		// scroll up
		js.executeScript("window.scroll(0,0)");
		Assert.assertTrue(FLOATING_MENU.isDisplayed());

	}

}
