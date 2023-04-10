package navpreet.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPageObject {

	WebDriver driver;
	Actions actions;
	Alert alert;

	public ContextMenuPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Context Menu']")
	private WebElement context;
	
	@FindBy(id = "hot-spot")
	private WebElement right_click;

	public void ClickContextMenu()
	{
		context.click();
	}
	
	public void Right_Click() {
		actions = new Actions(driver);
		actions.contextClick(right_click).build().perform();
	}

	public String AcceptingAndGrabbingTextOfAlert() {
		alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		alert.accept();
		return alert_text;
	}

}
