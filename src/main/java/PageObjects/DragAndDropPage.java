package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class DragAndDropPage extends BrowserUtilities {
	public DragAndDropPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "column-a")
	WebElement elementA;
	
	@FindBy(how = How.ID, using = "column-b")
	WebElement elementB;

	public void getUrl() {
		driver.get(BaseTest.getURL("drag_and_drop"));
	}
	public void dragAndDrop() {
		Actions actions = new Actions(driver);
		//actions.clickAndHold(elementA).moveToElement(elementB).release().build().perform();
		actions.clickAndHold(elementA).moveByOffset(-10, -10).moveToElement(elementB).release(elementB).build().perform();

	}
	public String getSourceText() {
		return getText(elementA);
	}
	public String getTargetText() {
		return getText(elementB);
	}
}
