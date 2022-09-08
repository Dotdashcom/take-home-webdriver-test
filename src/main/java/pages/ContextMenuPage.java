package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ContextMenuPage {
	static WebDriver driver;

	public ContextMenuPage(WebDriver driver) {
		ContextMenuPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//div[@id = 'hot-spot']")
	WebElement EMPTY_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "")
	WebElement CHECKBOX_2_RADIO_BUTTON_ELEMENT;

//	Methods
	public void rightClickInsideBox() {
		Actions actions = new Actions(driver);
		actions.contextClick(EMPTY_BOX_ELEMENT).perform();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateJavaScriptAlertMenuText() {
		String expectedJavaScriptAlertText = "You selected a context menu";
		String actualJavaScriptAlertText = driver.switchTo().alert().getText();
		 Assert.assertEquals(actualJavaScriptAlertText, expectedJavaScriptAlertText, "The JavaScript alert text did not generate or the message does not match!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pressingOKOnJavaScriptAlert() {
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
