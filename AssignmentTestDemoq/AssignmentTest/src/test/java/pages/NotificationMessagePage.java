package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.WebHelper;

public class NotificationMessagePage {

	private WebHelper helper;
	private WebDriver driver;

	public NotificationMessagePage(WebDriver driver , WebHelper helper) {		
		this.helper=helper;
		this.driver = driver;
	}

	By clickHere = By.xpath("//a[contains(text(),'Click here')]");
	By notificationMessage = By.cssSelector("#flash");


	public void DoubleClickOnALink() {
		helper.waitForElementToBeClickable(clickHere, 10);
		helper.DoubleClick(clickHere);
	}

	public void ClickOnALink() {
		helper.waitForElementToBeClickable(clickHere, 10);
		driver.findElement(clickHere).click();
	}

	public void VerifyNotificationMessage (String expectedMessage) {	

		String message = "";
		boolean val = false;

		for (int i =0; i<3;i++) {

			message = driver.findElement(notificationMessage).getText().trim();
			ClickOnALink();
			if (message.contains(expectedMessage)) {
				val = true;
				break;
			}	
		}

		Assert.assertTrue(val);					
	}			

}