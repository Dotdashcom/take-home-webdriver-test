package pages;

import org.openqa.selenium.By;


public class JavaScriptAlerts extends Driver{
	
			//Locators
			public static By JsAlertBtn = By.xpath("//button[contains(text(),'Click for JS Alert')]");
			public static By JsConfirmBtn = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
			public static By JsPrompt = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
		
			
			
			// Navigate to Login page
			public static void NavigateToJSAlertPage()
			{

				Driver.Instance.get(Baseurl+"//javascript_alerts");
			
			}
			
			// Get JSAlert message
			public static String GetAlertText()
			{
				Driver.Instance.findElement(JsAlertBtn).click();;
				String AlertMessage = Driver.Instance.switchTo().alert().getText();	
				Driver.Instance.switchTo().alert().accept();
				return AlertMessage.trim();

			}
			
			// Accept alert and get Text
			public static String AcceptAlertAndGetText()
			{
				Driver.Instance.findElement(JsConfirmBtn).click();;
				String AlertMessage = Driver.Instance.switchTo().alert().getText();
				Driver.Instance.switchTo().alert().accept();
				return AlertMessage;

			}
			

			// Open Alert and Write
			public static String OpenAlertAndEnterText()
			{
				Driver.Instance.findElement(JsPrompt).click();
				Driver.Instance.switchTo().alert().sendKeys("Js Prompt");				
				String message = Driver.Instance.switchTo().alert().getText();
				Driver.Instance.switchTo().alert().accept();
				return message;

			}		
			
			
			

}
