package navpreet.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPageObjects {

	WebDriver driver;
	JavascriptExecutor js;
	
	public FloatingMenuPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Floating Menu']")
	private WebElement click_floating_menu;
	
	@FindBy(id="menu")
	private WebElement floating_menu;
	
	public void ClickFloatingMenu()
	{
		click_floating_menu.click();
	}
	
	public void ScrollMenu()
	{
		js = (JavascriptExecutor)driver; 
	    js.executeScript("window.scrollBy(0,200)");
	}
	
	public boolean CheckFloatingMenu() {
		boolean isPresent=false;
		if(floating_menu.isDisplayed())
			isPresent=true;
		return isPresent;

	}
	
}
