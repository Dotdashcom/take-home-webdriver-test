package TheInternet.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotficationMessage extends Base {
	
	@FindBy(xpath="//a[text()='Click here']")
	WebElement clickHereLink;

	@FindBy(xpath="//div[@id='flash']")
	WebElement flashMessage;
	
	
	public void browserInitialization() {
		driverInitialization();
		PageFactory.initElements(driver, this);
		
	}
	

}
