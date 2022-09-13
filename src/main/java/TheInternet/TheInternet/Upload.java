package TheInternet.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Upload extends Base{
	
	@FindBy(xpath="//input[@id='file-upload']")
	WebElement fileUpload;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement fileUploadButton;
	
	public void browserInitialization() {
		driverInitialization();
		PageFactory.initElements(driver, this);
		
	}
	
	

}
