package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.TestBase;

public class FloatingMenuPage extends TestBase{

	@FindBy(id="menu")
	WebElement Menu;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/floating_menu");
		
	}
	
	public void scrollDown() {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,4000)");
}
	public boolean ValidateMenuPresent() {
		return Menu.isDisplayed();
		
	}
	public void closeBrowser() {
		driver.quit();
	}
}
