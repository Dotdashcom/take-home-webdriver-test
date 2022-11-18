package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.WebHelper;

public class DynamicLoadingPage {
	
	private WebHelper helper;
	private WebDriver driver;

		public DynamicLoadingPage(WebDriver driver , WebHelper helper) {		
			this.helper=helper;
			this.driver = driver;
		}
		
		By startButton = By.cssSelector("#start button");
		By messageElement = By.cssSelector("#finish h4");
		
		
		public void ClickStartButton() {
			driver.findElement(startButton).click();
			helper.waitForElementTextAppears(messageElement, 0, "Hello World!");
		}
		
		public void VerifyHelloWorld(String text) {
			Assert.assertEquals(text, driver.findElement(messageElement).getText());
		}

}
