package pages;

import org.openqa.selenium.By;


public class NotificationMessage extends Driver {
	
	//Locators
			public static By ClickButton = By.xpath("//a[contains(text(),'Click here')]");
			public static By Flashmessage = By.id("flash");
			
		
			// Navigate to Login page
			public static void NavigateToNotificationsPage()
			{

				Driver.Instance.get(Baseurl+"//notification_message_rendered");
			
			}
			
			//click clickhere button
			
			public static void ClickHereButton() {
				Driver.Instance.findElement(ClickButton).click();
			}
			
			//Validate the flash message
			
			public static String GetFlashMessage() {
				return Driver.Instance.findElement(Flashmessage).getText().trim();
			}

}
