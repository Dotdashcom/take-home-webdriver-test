package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationMessagePage {
	public WebDriver driver;

	public NotificationMessagePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p/a")
	private WebElement clickHere;

	@FindBy(id="flash")
	private WebElement flashMessage;



	public void renderNotification(String message1, String message2) throws InterruptedException  {
		String text1 = null;
		String text2 = null;
		do {
			clickHere.click();
			if((flashMessage.getText()).substring(0, 17).equalsIgnoreCase(message1)) {
				text1=(flashMessage.getText()).substring(0, 17);
			} else {
				text2=(flashMessage.getText()).substring(0, 36);
			}
			if(text1!=null && text2!=null) {
				Assert.assertEquals(text1, message1);
				Assert.assertEquals(text2, message2);
				break;
			}

		}while ((flashMessage.getText()).substring(0, 17).equalsIgnoreCase(message1) || (flashMessage.getText()).substring(0, 36).equalsIgnoreCase(message2));

	}
}
