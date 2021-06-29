package module;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuration.PageLoader;

public class IFrame {
	
	private WebDriver driver = null;
	private WebElement editor = null;	

	final String iFrameId = "mce_0_ifr";
	final String editorId = "tinymce";
	
	public IFrame(WebDriver driver) {
		this.driver = driver;
		this.loadPage();		

		driver.switchTo().frame(iFrameId);
		editor = driver.findElement(By.id(editorId));
	}
	
	/**
	 * Type the message into the editor.
	 * Recommended to clear editor first.
	 * @param message - Message to type in to editor
	 */
	public void typeIntoEditor(String message) {		
		editor.sendKeys(message);		
	}
	
	/**
	 * Clear out the contents of the editor
	 */
	public void clearEditor() {
		// CTRL-A to select all		
		editor.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// Backspace to delete it
		editor.sendKeys(Keys.BACK_SPACE);
	}
	
	public String getEditorText() {
		return editor.getText();
	} 

	public void loadPage() {
		PageLoader.loadPage(driver, "/iframe");		
	}	
	
	
}
