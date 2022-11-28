package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class FloatingMenuPage extends BrowserUtilities {

	public FloatingMenuPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Home')]")
	WebElement bt_HomeMenu;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'News')]")
	WebElement bt_NewsMenu;	


	public void getUrl() {
		driver.get(BaseTest.getURL("floating_menu"));
	}
	
	public void scrollToTheBottomOfThePage() {
		bt_NewsMenu.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		   bt_NewsMenu.isDisplayed();
	}
	
}
