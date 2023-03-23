package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage extends BaseClass{
	public boolean textAction;
	public NotificationPage(){
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath="//*[@id='content']/div/p/a")
 private WebElement linkClickHere;
 
 @FindBy(xpath="//*[@id='flash']")
 private WebElement notificationText;
 
 public boolean validatetext() {
	 System.out.println("user in validateText method");
	 linkClickHere.click();
	 
	 System.out.println("user clicked");
	 String getNotificationText = notificationText.getText();
	 
	 System.out.println("getNotificationText is: "+getNotificationText);
	 if(getNotificationText.contains("Action successful") || getNotificationText.contains("Action unsuccesful")) {
		 textAction=true;
	 }
	 else {
		 textAction=false;
	 }
	 return textAction;
 }
}
