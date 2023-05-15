package pageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
	private WebDriver driver;

	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "hot-spot")
	private WebElement boxField;
	
	public void contextClick() {
		Actions action = new Actions(driver);
		action.contextClick(boxField).build().perform();;	
	}
	
	public String alertText() {
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.dismiss();
		return message;				
	}
}
