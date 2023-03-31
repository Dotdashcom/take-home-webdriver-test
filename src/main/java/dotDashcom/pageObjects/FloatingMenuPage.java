package dotDashcom.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {
	WebDriver driver;

	public FloatingMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="menu")
	private WebElement floatingMenu;
	
	public void scrollDown() {
		Actions at = new Actions(driver);
	      at.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	public boolean checkFloatingMenu() {
		boolean isPresent=false;
		if(floatingMenu.isDisplayed())
			isPresent=true;
		return isPresent;
		
	}
}
