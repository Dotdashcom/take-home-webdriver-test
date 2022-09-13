package TheInternet.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptErrors extends Base{
	
	
	public void browserInitialization() {
		driverInitialization();
		PageFactory.initElements(driver, this);
		
	}
	

}
