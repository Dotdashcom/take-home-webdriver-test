package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage extends BaseClass {

	@FindBy(xpath = "//a[text()='Click here']")
	public WebElement clickButton;

	@FindBy(xpath = "//div[@class='flash notice']")
	public WebElement Message;

	public NotificationPage() {
		PageFactory.initElements(driver, this);

	}

}
