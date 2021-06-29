package module;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.PageLoader;

public class FloatingMenu {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.ID, using="menu")	
	private WebElement menu;
	
	public FloatingMenu(WebDriver driver) {
		this.driver = driver;
		this.loadPage();		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Scroll to bottom of the page
	 */
	public void scrollToBottom() {				
		
		//System.out.println("is footer in view? " + this.isElementInViewport( driver.findElement(By.id("page-footer"))));
		
		 String scrollScript = "window.scrollTo(0, document.body.scrollHeight);";
		 
		 JavascriptExecutor jse = ((JavascriptExecutor) driver);
		 jse.executeScript(scrollScript);		 		
		 
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Check if the Menu is fully visible on the screen
	 */
	public boolean isMenuVisible() {
		/* Needed to use JS method.  Selenium calls such as element.isDisplayed()
		 * or expected conditions elementToBeClickable()/elementToBeVisible()
		 * will return true even if the item is off screen. */
		return this.isElementInViewport(menu);				
	}
	
	/**
	 * Helper method to check if elements are visible on screen
	 * (i.e. showing on the viewport)
	 * @param element - element to check
	 * @return true if element fully on viewport, false otherwise
	 */
	private boolean isElementInViewport(WebElement element) {

		// Inject some JavaScript to help us.
		// Read from file, because there is a ton of JS needed...
		String scriptFile = System.getProperty("user.dir") + "/src/test/resources/IsElementInViewport";
		String script = null;
		try {
			script = new String(Files.readAllBytes(Paths.get(scriptFile)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		// Add on to the script to invoke the function
		script += "\r\n"
				+ "return isElementInViewport(document.getElementById('"+ element.getAttribute("id") +"'));";
		return (Boolean) jse.executeScript(script);		
	}

	public void loadPage() {
		PageLoader.loadPage(driver, "/floating_menu");		
	}	
	
	
}
