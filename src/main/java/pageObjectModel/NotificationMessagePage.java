package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage {
	private WebDriver driver;

	public NotificationMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String message1 = "Action unsuccesful, please try again";
	String message2 = "Action successful";

	@FindBy(how = How.XPATH, using = "//a[text()='Click here']")
	private WebElement clickButton;

	@FindBy(how = How.ID, using = "flash")
	private WebElement messageField;

	public boolean clickButtonMultiple() {
		int oneCount = 0;
		int twoCount = 0;
		for (int i = 0; i < 50; i++) {
			clickButton.click();
			String actualMessage = messageField.getText();
			if (actualMessage.contains(message1)) {
				oneCount++;

			} else if (actualMessage.contains(message2)) {
				twoCount++;
			}
		}
		if (oneCount > 0 && twoCount > 0) {
			return true;
		}
		return false;
	}
}
