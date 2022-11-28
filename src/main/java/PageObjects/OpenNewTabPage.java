package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class OpenNewTabPage extends BrowserUtilities {
	public OpenNewTabPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
	WebElement openNewTabLink;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'New Window')]")
	WebElement newWindowText;
	
	public void getUrl() {
		driver.get(BaseTest.getURL("windows"));
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public void openNewTab() {
		Click(openNewTabLink);
	}
}
