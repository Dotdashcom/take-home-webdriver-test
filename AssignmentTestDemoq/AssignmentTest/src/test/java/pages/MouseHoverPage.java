package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class MouseHoverPage {
	
	
   
	private WebDriver driver;

		public MouseHoverPage(WebDriver driver ) {		
			
			this.driver = driver;
		}
		
		By userFigures = By.cssSelector(".figure img");
		By figuresNames = By.cssSelector(".figcaption h5");
		
		
		public void HoverUserImage(int imageNumber) {
			Actions actions = new Actions(driver);			
			actions.moveToElement(driver.findElements(userFigures).get(imageNumber)).build().perform();			
		}
		
		public void VerifyUserName (int imageNumber, String expectedUser) {
			String actual = driver.findElements(figuresNames).get(imageNumber).getText() ;
			
			Assert.assertEquals(actual, expectedUser);
		}

}
