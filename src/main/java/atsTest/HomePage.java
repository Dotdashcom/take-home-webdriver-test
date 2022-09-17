package atsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	  // <h1>Hello userName</h1>
	  private By messageSuccess = By.tagName("h2");
	  private By messageFailure = By.xpath("//*[@class=\"flash error\"]");

	  public HomePage(WebDriver driver){
	    this.driver = driver;
	    if (!driver.getTitle().equals("The Internet")) {
	      throw new IllegalStateException("This is not Home Page of logged in user," +
	            " current page is: " + driver.getCurrentUrl());
	    }
	  }
	  public String getMessageText() {
	    return driver.findElement(messageSuccess).getText();
		    
		  }
	  public String getInvalidMessageText() {
		    return driver.findElement(messageFailure).getText();
			    
			  }

		  public HomePage manageProfile() {
		    // Page encapsulation to manage profile functionality
		    return new HomePage(driver);
		  }
}
