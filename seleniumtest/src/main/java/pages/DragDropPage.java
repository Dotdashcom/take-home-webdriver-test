package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class DragDropPage extends GenericPage {

	@FindBy(xpath = "//div[@id ='column-a']")
	private WebElement boxA;

	@FindBy(xpath = "//div[@id ='column-b']")
	private WebElement boxB;

	public DragDropPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void dragDrop() {
		Actions actions = new Actions(driver);
        actions.dragAndDrop(boxA, boxB).perform();
	}
}