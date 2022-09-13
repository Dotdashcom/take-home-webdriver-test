package TheInternet.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Iframe extends Base{
	
	
	@FindBy(xpath="//iframe[@id='mce_0_ifr']")
	WebElement iframe;
	
	@FindBy(xpath="//body[@id='tinymce']/p")
	WebElement iframeParagraphBox;
	
	@FindBy(xpath="//button[contains(@class,'dismiss')]")
	WebElement closeButton;

	
	public void browserInitialization() {
		driverInitialization();
		PageFactory.initElements(driver, this);
		
	}
	
	

}
