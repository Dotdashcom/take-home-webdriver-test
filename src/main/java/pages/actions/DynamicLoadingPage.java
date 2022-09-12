package pages.actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.Page;

public class DynamicLoadingPage extends Page{
	
	public void verifyStartButton() {
		click(locators.startBtn);
		Page.wait.until(ExpectedConditions.textToBePresentInElement(locators.finish, "Hello World!"));
		System.out.println("expected text: "+ locators.finish.getText());
		String expectedText = "Hello World!";
		Assert.assertEquals(locators.finish.getText(), expectedText);
		
	}

}
