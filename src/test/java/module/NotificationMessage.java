package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configuration.PageLoader;

public class NotificationMessage {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.LINK_TEXT, using="Click here")
	private WebElement clickHere;
	
	public NotificationMessage(WebDriver driver) {
		this.driver = driver;
		this.loadPage();
		PageFactory.initElements(driver, this);
	}
	
	public void loadNewMessage() {
		clickHere.click();
	}
	
	public String getMessage() {
		WebElement flash = driver.findElement(By.id("flash"));
		return flash.getText();
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/notification_message_rendered");		
	}
}
