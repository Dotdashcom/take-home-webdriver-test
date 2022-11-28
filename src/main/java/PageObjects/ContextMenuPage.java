package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class ContextMenuPage extends BrowserUtilities {
	public ContextMenuPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "hot-spot")
	WebElement contextMenu;

	public void getUrl() {
		driver.get(BaseTest.getURL("context_menu"));
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public void rightClickContextMenu() {
		fnRightClickButton(contextMenu);
	}
	
}
