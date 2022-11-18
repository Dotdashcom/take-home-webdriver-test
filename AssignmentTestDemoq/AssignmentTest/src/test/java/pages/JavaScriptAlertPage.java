package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.WebHelper;

public class JavaScriptAlertPage {

	private WebHelper helper;
	private WebDriver driver;

		public JavaScriptAlertPage(WebDriver driver , WebHelper helper) {		
			this.helper=helper;
			this.driver = driver;
		}
		
		By javaScriptAlertButton = By.xpath("//button[contains(text(),'JS Alert')]");
		By javaScriptConfirmButton = By.xpath("//button[contains(text(),'JS Confirm')]");
		By javaScriptPromptButton = By.xpath("//button[contains(text(),'Prompt')]");
		
		public void ClickButton (String button) {
			
			switch (button) {
			case "Alert":
				driver.findElement(javaScriptAlertButton).click();
				 break;
				
			case"Confirm":
				driver.findElement(javaScriptConfirmButton).click();
				break;
				
			case "Prompt":
			driver.findElement(javaScriptPromptButton).click();
			break;
			
			default:
				throw new IllegalArgumentException("Invalid button");
			}
		}
		
		public void VerifyAlertText(String actual) {
			Assert.assertEquals(actual, helper.GetalertText());
		}
		
}
