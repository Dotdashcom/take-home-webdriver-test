package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DragAndDropPage {

	WebDriver driver;

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Drag and Drop')]")
	WebElement DRAGANDDROP_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@id='column-a']")
	WebElement A_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@id='column-b']") WebElement B_ELEMENT;
	

	public void dragAndDropMenu() {
		DRAGANDDROP_MENU_ELEMENT.click();
	}

	public void dragAndDropToAndFrom() throws InterruptedException {
		
		String actual_Source_elementA = A_ELEMENT.getText();
		String actual_Source_elementB = B_ELEMENT.getText();
		
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		//drag and drop has a bug
		act.dragAndDrop(A_ELEMENT, B_ELEMENT).build().perform();
		
	//	Assert.assertEquals(actual_Source_elementA, B_ELEMENT);
	//	Assert.assertEquals(actual_Source_elementB, A_ELEMENT);
		
	}

}
