package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class Notification extends BaseClass{
	@FindBy(linkText = "Click here")
	private WebElement clickLnk;

	@FindBy(xpath = "//div[@class='flash notice']")
	private WebElement msg;

	public Notification() {
		PageFactory.initElements(driver, this);
	}

	public boolean NotificationMsg() throws InterruptedException {
		clickLnk.click();
		Thread.sleep(2000);

		String text = msg.getText();
		if("Action successful\n×".equals(text) || "Action unsuccesful, please try again\n×".equals(text) ) {
			return true;
		}
		return false;
	}

}
