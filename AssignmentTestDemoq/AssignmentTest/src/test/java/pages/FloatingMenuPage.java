package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FloatingMenuPage {
	
	    
		private WebDriver driver;

			public FloatingMenuPage(WebDriver driver ) {		
				
				this.driver = driver;
			}
			
			By menu = By.cssSelector("#menu");
			
			
			public void isMenuDisplayed() {
				driver.findElement(menu).isDisplayed();
			}		

}
