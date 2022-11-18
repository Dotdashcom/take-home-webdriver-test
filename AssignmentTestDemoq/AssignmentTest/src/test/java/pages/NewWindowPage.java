package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewWindowPage {
	
	
		private WebDriver driver;

			public NewWindowPage(WebDriver driver) {		
			
				this.driver = driver;
			}
			
			By newWindowElement = By.xpath("//h3[contains(text(),'New Window')]");
			
			
			public void VerifyNewWindowText(String actual) {
				Assert.assertEquals(actual, driver.findElement(newWindowElement).getText());
			}
}
