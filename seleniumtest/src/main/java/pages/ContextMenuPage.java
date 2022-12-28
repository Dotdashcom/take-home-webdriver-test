package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class ContextMenuPage extends GenericPage {

	@FindBy(id = "hot-spot")
	public WebElement contextMenu;

	public ContextMenuPage() {
		PageFactory.initElements(driver, this);
	}
}