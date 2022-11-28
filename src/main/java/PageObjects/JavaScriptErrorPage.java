package PageObjects;

import org.openqa.selenium.support.PageFactory;
import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class JavaScriptErrorPage extends BrowserUtilities {
	public JavaScriptErrorPage() {
		PageFactory.initElements(driver, this);
	}


	public void getUrl() {
		driver.get(BaseTest.getURL("javascript_error"));
	}
	public String getTitle() {
		return driver.getTitle();
	}
}
