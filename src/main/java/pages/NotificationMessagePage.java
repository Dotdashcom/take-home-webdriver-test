/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

/**
 * @author choudhuryIqbal
 *
 */
public class NotificationMessagePage extends BasePage {

	public NotificationMessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[contains(text(),'Click here')]")
	WebElement clickHere;

	@FindBy(id = "flash-messages")
	WebElement msg;

	public void clickLink() throws Exception {
		clickHere.click();
	}

	public boolean verifyNotificationMsg()  throws Exception{
		boolean flag = false;
		for (int i = 0; i < 3; i++) {
			clickLink();
			String text = msg.getText();
			if ((text.contains("Action unsuccesful, please try again") || text.contains("Action successful"))) {
				flag = true;
			} else {
				return false;
			}
		}
		return flag;
	}

}
