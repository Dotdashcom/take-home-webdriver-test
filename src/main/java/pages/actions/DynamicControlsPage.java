package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Page;

public class DynamicControlsPage extends Page {
	
	
	
	public void verifyCheckboxIsGone() {

		click(locators.removeBtn);
		Page.wait.until(ExpectedConditions.elementToBeClickable(locators.addBtn));
		System.out.println("checking for it's gone message to be displayed: "+locators.message.getText());
		Assert.assertEquals(locators.message.getText(), "It's gone!");
	
	
	}
	
	public void verifyCheckboxIsPresent() {
		click(locators.addBtn);
		Page.wait.until(ExpectedConditions.elementToBeClickable(locators.removeBtn));
		click(locators.removeCheckbox);
		Assert.assertEquals(true, locators.removeCheckbox.isSelected());
		
	}
	
	
	public void verifyEnableButton() {
		click(locators.enableBtn);
		Page.wait.until(ExpectedConditions.elementToBeClickable(locators.disableBtn));
		System.out.println("checking for it's enabled message to be displaed: "+ locators.message.getText());
		Assert.assertEquals(true, locators.textBox.isEnabled());	
	}
	
	public void verifyDisableButton() {
		click(locators.disableBtn);
		Page.wait.until(ExpectedConditions.elementToBeClickable(locators.enableBtn));
		System.out.println("checking for it's disabled message to be displaed: "+ locators.message.getText());
		Assert.assertEquals(false, locators.textBox.isEnabled());	
	}
	
	

}
