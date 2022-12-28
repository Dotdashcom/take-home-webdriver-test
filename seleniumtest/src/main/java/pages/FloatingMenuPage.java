package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class FloatingMenuPage extends GenericPage {

	@FindBy(xpath = "//div[@id='menu']")
	private WebElement menuItem;

	public FloatingMenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getFloatingMenu() throws InterruptedException {
		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		jsExec.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		jsExec.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		return menuItem.isDisplayed();
	}
}