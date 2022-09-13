package TheInternet.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptAlerts extends Base{
	
	
	@FindBy(xpath="//button[contains(text(),'JS Alert')]")
	WebElement jsAlertButton;
	
	@FindBy(xpath="//button[contains(text(),'JS Confirm')]")
	WebElement jsAlertConfirm;
	
	@FindBy(xpath="//button[contains(text(),'JS Prompt')]")
	WebElement jsAlertPrompt;
	
	
	
	public void browserInitialization() {
		driverInitialization();
		PageFactory.initElements(driver, this);
		
	}
	
	

}
