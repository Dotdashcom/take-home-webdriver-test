package navpreet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationMessagePageObjects {

	WebDriver driver;
	String message;
	
	public NotificationMessagePageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/notification_message']")
	private WebElement clickNotification;

	@FindBy(xpath="//a[@href='/notification_message']")
	private WebElement clickHere;
	
	@FindBy(id="flash")
	private WebElement flash;
	
	public void clickNotificationMessages()
	{
		clickNotification.click();
	}
	
	public void clickClickHere()
	{
		clickHere.click();
	}
	
	public void Notifications()
	{
		if(flash.getText().split("×")[0].equalsIgnoreCase("Action successful"))
			Assert.assertTrue(true);
		else if(flash.getText().split("×")[0].equalsIgnoreCase("Action unsuccesful, please try again"))
			Assert.assertTrue(true);
		
		System.out.println(flash.getText().split("×")[0]);
		
	}
}
