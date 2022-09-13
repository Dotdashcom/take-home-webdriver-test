package TheInternet.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDrop extends Base{
	
	@FindBy(xpath="//div[@id='column-a']")
	WebElement elementA;
	
	@FindBy(xpath="//div[@id='column-b']")
	WebElement elementB;
	
	public void browserInitialization() {
		driverInitialization();
		PageFactory.initElements(driver, this);
		
	}
	
	

}
