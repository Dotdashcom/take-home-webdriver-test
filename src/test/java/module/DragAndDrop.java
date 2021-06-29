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

import configuration.PageLoader;

public class DragAndDrop {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.ID, using="column-a")
	private WebElement leftBox;
	
	@FindBy(how=How.ID, using="column-b")
	private WebElement rightBox;
	
	public DragAndDrop(WebDriver driver) {
		this.driver = driver;
		this.loadPage();
		PageFactory.initElements(driver, this);		
	}
	
	public String getLeftBoxText() {
		return leftBox.getText();
	}
	
	public String getRightBoxText() {
		return rightBox.getText();
	}	
	
	public void dragLeftBoxOntoRight() {		
		// Had to use JS method
		dragSourceToDestinationUsingJavaScript(leftBox, rightBox);	
	}
	
	public void dragRightBoxOntoLeft() {
		// Had to use JS method
		dragSourceToDestinationUsingJavaScript(rightBox, leftBox);
	}
		
	public void loadPage() {
		PageLoader.loadPage(driver, "/drag_and_drop");		
	}
	
	
	
	/**
	 * Use JavaScript to drag a source element to a destination element
	 * 
	 * I was not able to successfully drag and drop using the Selenium functions. Not
	 * sure if it's a driver / browser / os / emulation quirk. It may go away in
	 * future versions.
	 * 
	 * Here are some unsuccessful attempts, which I expected to work but didn't.
	 * 
	 * // Attempt 1: 
	 * Actions action = new Actions(driver);
	 * action.dragAndDrop(leftBox, rightBox).build().perform();
	 * 
	 * // Attempt 2: 
	 * Actions action = new Actions(driver); 
	 * action.clickAndHold(leftBox)
	 * .moveToElement(rightBox)
	 * .release(rightBox)
	 * .build()
	 * .perform();
	 * 
	 * Therefore, this function was written to help get by in the meantime.
	 * 
	 * @param src  - the source element
	 * @param dest - the destination element
	 */
	private void dragSourceToDestinationUsingJavaScript(WebElement src, WebElement dest) {

		// Inject some JavaScript to help us.
		// Read from file, because there is a ton of JS needed...
		String scriptFile = System.getProperty("user.dir") + "/src/test/resources/SimulateDragAndDrop";
		String script = null;
		try {
			script = new String(Files.readAllBytes(Paths.get(scriptFile)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		// Add on to the script to invoke the function
		script += "\r\n"
				+ "simulateDragDrop(document.getElementById('"+ src.getAttribute("id")+"'), document.getElementById('"+dest.getAttribute("id")+"'));";
		jse.executeScript(script);
	}
		
}
