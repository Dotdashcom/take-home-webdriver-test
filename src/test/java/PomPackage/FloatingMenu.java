package PomPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class FloatingMenu extends BaseClass {
	@FindBy(xpath = "//div[@id='menu']")
	private WebElement menu;

	public FloatingMenu() {
		PageFactory.initElements(driver, this);
	}

	public boolean getFloatingMenu() throws InterruptedException {
		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		jsExec.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		jsExec.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		return menu.isDisplayed();
	}

}
