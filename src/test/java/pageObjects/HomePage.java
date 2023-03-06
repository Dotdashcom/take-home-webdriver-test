package pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BaseTemplate {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
		public String getHomePageURL(){
		 return	driver.getCurrentUrl();
		}
		
}
