package TheInternet.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkboxes extends Base{
	
	
	@FindBy(xpath="//input[@type='checkbox'][1]")
	WebElement checkbox1;
	
	@FindBy(xpath="//input[@type='checkbox'][2]")
	WebElement checkbox2;

	
	public void browserInitialization() {
		driverInitialization();
		PageFactory.initElements(driver, this);
		
	}
	
	
}
