package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class Notification extends BaseTest{

	public Notification() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/notification_message']")
	private static  WebElement link;
	
	@FindBy(id="flash")
	private static WebElement success;
	
	public void clicklink() {
		driver.navigate().refresh();
		link.click();
		if(success.getText().toString().equals("Action unsuccesful, please try again") || success.getText().toString().equals("Action successful")) {
			System.out.println(success.getText().toString());
		}
	}
}