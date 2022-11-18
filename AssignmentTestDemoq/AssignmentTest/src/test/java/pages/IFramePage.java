package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IFramePage {
	
	    
		private WebDriver driver;

			public IFramePage(WebDriver driver) {		
				
				this.driver = driver;
			}
			
			By IFrameElement = By.cssSelector("#mce_0_ifr");
			By closeLabel = By.cssSelector(".tox-icon");
			By textEditor = By.cssSelector("#tinymce p");
			
			public void SwicthToIframe() {
				driver.switchTo().frame(driver.findElement(IFrameElement));
			}
			
			public void DefaultContent() {
				driver.switchTo().defaultContent();
			}
			
			public void ClickCloseLabel() {				
				driver.findElement(closeLabel).click();				
			}
			
			public void EnterTextEditor(String expectedText) {
				SwicthToIframe();
				driver.findElement(textEditor).sendKeys(Keys.CONTROL + "a");
				driver.findElement(textEditor).sendKeys(Keys.DELETE);
				driver.findElement(textEditor).sendKeys(expectedText);
				DefaultContent();
			}
			
			public void VerifyText(String actual) {
				SwicthToIframe();
				Assert.assertEquals(actual, driver.findElement(textEditor).getText());
				DefaultContent();
			}
}
