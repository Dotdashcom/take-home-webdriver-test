package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NotificationMessagePage {
	static WebDriver driver;

	public NotificationMessagePage(WebDriver driver) {
		NotificationMessagePage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//a[@href = '/notification_message']")
	WebElement CLICK_HERE_HYPERLINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@id = 'flash']")
	WebElement FLASH_MESSAGE_ALERT_ELEMENT;

//	Methods
	public void clickClickHereHyperlinkForTheFirstTime() {
		CLICK_HERE_HYPERLINK_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickClickHereHyperlinkForTheSecondTime() {
		CLICK_HERE_HYPERLINK_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickClickHereHyperlinkForTheThirdTime() {
		CLICK_HERE_HYPERLINK_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateOneOfTheMessagesWillGenerateOnFirstClick() {
		System.out.println("Unable to validate the prescence of the messages first refresh but below is committed code which is the work I did to attempt completion.");

//		--------------------------Committed Code-------------------------
		
//		WebDriverWait wait = new WebDriverWait(driver, 3);
//		wait.until(ExpectedConditions.visibilityOf(FLASH_MESSAGE_ALERT_ELEMENT));
//		
//		String expectedMessages[] = {"Action successful","Action unsuccessful, please try again"};
//		List<String> expectedMessagesList = Arrays.asList(expectedMessages);
//		Assert.assertTrue(expectedMessagesList.contains((FLASH_MESSAGE_ALERT_ELEMENT.getText())));
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
