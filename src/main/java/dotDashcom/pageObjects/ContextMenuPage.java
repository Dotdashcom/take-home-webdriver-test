package dotDashcom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {
	WebDriver driver;

	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="hot-spot")
	private WebElement contextBox;
	
	
	public void rightClick() {
		Actions action=new Actions(driver);
		action.contextClick(contextBox).perform();
	}
	public String getAlertMessage() {
		String message=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return message;
	}
	
}
