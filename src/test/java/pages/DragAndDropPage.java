package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utilities.TestUtility;

public class DragAndDropPage {

	WebDriver driver;

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(id = "column-a")
	WebElement boxA;

	@FindBy(id = "column-b")
	WebElement boxB;
	
	public DragAndDropPage dragAndDrop() throws Exception {
        TestUtility.DragAndDropJS(boxA, boxB);
        return this;
    }

	public Boolean verifyDragAndDrop() {
		String elementAHeader = boxA.findElement(By.xpath("descendant::header")).getText();
		String elementBHeader = boxB.findElement(By.xpath("descendant::header")).getText();
		return elementAHeader.equals("B") && elementBHeader.equals("A");
	}

	// get url
	public DragAndDropPage getUrl() {
		driver.navigate().to(TestBase.url + "/drag_and_drop");
		return this;
	}
}
