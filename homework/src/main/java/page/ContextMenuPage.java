package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ContextMenuPage {

	WebDriver driver;

	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Context Menu')]")
	WebElement CONTEXT_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@id='hot-spot']")
	WebElement RIGHTCLICK_ELEMENT;

	public void clickMenu() {
		CONTEXT_MENU_ELEMENT.click();
	}

	public void rightClickElement() throws InterruptedException {
		// performing a right click
		Actions act = new Actions(driver);
		act.contextClick(RIGHTCLICK_ELEMENT).perform();

		Thread.sleep(2000);
		// switch to alert box and click on the OK button
		Alert alert = driver.switchTo().alert();

		String actualResult = "You selected a context menu";
		String expectedResult = driver.switchTo().alert().getText();
		System.out.println("actual message: " + actualResult);
		System.out.println("expected message: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);

		alert.accept();

	}
}
