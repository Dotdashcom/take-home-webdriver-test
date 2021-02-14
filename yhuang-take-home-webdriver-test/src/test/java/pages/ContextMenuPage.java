package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BaseDriver{
	private Actions actions;
	
	@FindBy(id = "hot-spot")
    public WebElement hotSpot;
	
	public ContextMenuPage(WebDriver driver){
		super(driver);
        this.actions = new Actions(driver);
    }
	
	public void rightClickMenu() {
		actions.contextClick(hotSpot).perform();;
	}
	
	public String getAlertTextAndCloseAlert() {
		String alertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		actions.sendKeys(Keys.ESCAPE);
		return alertMsg;
	}
}
