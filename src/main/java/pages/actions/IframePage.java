package pages.actions;

import org.testng.Assert;

import base.Page;

public class IframePage extends Page {
	
	public void verifyIframe() {
		click(locators.iframeCloseBtn);
		driver.switchTo().frame("mce_0_ifr");
		type(locators.iFrameTextBox, "Hello World! ");
		System.out.println(locators.iFrameTextBox.getText());
		Assert.assertEquals(locators.iFrameTextBox.getText(), "Hello World! Your content goes here.");
		
	}

}
