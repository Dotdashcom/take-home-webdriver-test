package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage extends BasePage {

	private String page = "iframe";
	
	private String frameId = "mce_0_ifr";
	
	private By frameBody = By.tagName("body");
	
	public IframePage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}
	
	public String getFrameId() {
		return frameId;
	}
	
	public By getFrameBody() {
		return frameBody;
	}
	
	public void goToFrame() {
		driver.switchTo().frame(frameId);
	}
	
	public void clearFrame() {
		driver.findElement(frameBody).clear();
	}
	
	public void writeOnFrame(String message) {
		driver.findElement(frameBody).sendKeys(message);;
	}
	
	public String getFrameMessage() {
		return driver.findElement(frameBody).getText();
	}

}
