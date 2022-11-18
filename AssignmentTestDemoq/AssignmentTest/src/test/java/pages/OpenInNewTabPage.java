package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.WebHelper;

public class OpenInNewTabPage {

	
	private WebHelper helper;
	private WebDriver driver;

		public OpenInNewTabPage(WebDriver driver , WebHelper helper) {		
			this.helper=helper;
			this.driver = driver;
		}
		
		By clickHere = By.xpath("//a[contains(text(),'Click Here')]");
		
		public void ClickLink() {
			driver.findElement(clickHere).click();
			helper.SwitchWindowHandles();
		}
		
		public String CurrentWindowHandle(){
			
			return driver.getWindowHandle();			
		}
		
		public void VerifyNewTab(String actual) {
			Assert.assertEquals(actual, driver.getTitle());
			
		}
}
