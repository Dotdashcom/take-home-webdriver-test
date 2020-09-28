/**
 * 
 */
package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import base.WebLink;

/**
 * @author choudhuryIqbal
 *
 */
public class FloatingMenuPage extends BasePage {

	public FloatingMenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id ="menu")
	WebElement floatinMenu;
	
	public void scrollByPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application		
      //  driver.get("http://demo.guru99.com/test/guru99home/");

        //To maximize the window. This code may not work with Selenium 3 jars. If script fails you can remove the line below		
      //  driver.manage().window().maximize();

        // This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,1000)");
		
	}
	public boolean isMenuDisplayed() {
	//	retrun false;
		return floatinMenu.isDisplayed();
	}
	
	

}
