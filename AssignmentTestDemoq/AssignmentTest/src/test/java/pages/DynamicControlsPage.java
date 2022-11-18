package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.WebHelper;

public class DynamicControlsPage {
	
	private WebHelper helper;
	private WebDriver driver;

		public DynamicControlsPage(WebDriver driver , WebHelper helper) {		
			this.helper=helper;
			this.driver = driver;
		}
		
		public By removeAddButton = By.cssSelector("#checkbox-example button");
		public By loadingTextForRemoveButton = By.cssSelector("#loading");
		public By CheckBoxA = By.cssSelector("#checkbox-example #checkbox");
		public By message = By.cssSelector("#checkbox-example #message");
		public By enableButton = By.xpath("//button[contains(text(),'Enable')]");
		public By disableButton = By.xpath("//button[contains(text(),'Disable')]");
		public By textBox = By.cssSelector("#input-example input");
		public By enableDisableMessage = By.xpath("//p[@id='message']");
		
		
		
		public void clickButton(String value , String actualMessage) {
			
			By messageValue = null;
			
			switch(value) {
			case "Add/Remove Button" :
				helper.waitForElementToBeClickable(removeAddButton, 10).click();	
				messageValue = message;
				break;
				
			case "Enable Button" :
				helper.waitForElementToBeClickable(enableButton, 10).click();
				messageValue =disableButton;
				break;
				
			case "Disable Button" :
				helper.waitForElementToBeClickable(disableButton, 10).click();	
                messageValue = enableButton;
				break;
				
			case "CheckBox":
				helper.waitForElementToBeClickable(CheckBoxA, 10).click();
				break;
				
			default:
				throw new IllegalArgumentException("Invalid button");
			}
			
			if (!value.equals("CheckBox")) {
				helper.waitForElementTextAppears(messageValue, 10, actualMessage);
			}
			
			
		}	
		
		public Boolean TextBoxEnableDisable() {
			Boolean value =false;
			try {
				    if(driver.findElement(textBox).getAttribute("disabled") == null) {
				    	value = true;
				    	
				    }
			}catch (Exception e) {
				value=false;
			}			
			return value;
		}
		
		public void VerifyTextBoxIsEnabled (String actualMessage) {
			helper.waitForElementTextAppears(enableDisableMessage, 10, actualMessage);
			Assert.assertTrue(TextBoxEnableDisable());
		}
		
		public void VerifyTextBoxIsDisabled (String actualMessage) {
			helper.waitForElementTextAppears(enableDisableMessage, 10, actualMessage);
			Assert.assertFalse(TextBoxEnableDisable());
		}
		
		public boolean CheckBox(String button) {
			Boolean value = false;
			try {
				clickButton("CheckBox","");
				value=false;
			}
			catch(Exception e) {
				value=true;
			}
			return value;
		}
		
		public void VerifyCheckboxDoesNotExists(String button) {
			Assert.assertTrue(CheckBox(button));
		}
		
		public void VerifyCheckboxExists(String button) {
			Assert.assertFalse(CheckBox(button));
		}
		
		
		

}
