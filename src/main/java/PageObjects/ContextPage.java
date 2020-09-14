package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContextPage {
	
	WebDriver driver;
	
	//*[@id="hot-spot"]
	
	By context= By.xpath("//*[@id='hot-spot']");
	
	public ContextPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement getContext()
	{
		return driver.findElement(context);
	}
	
	

}
