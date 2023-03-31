package dotDashcom.pageObjects;

import java.awt.AWTException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
	WebDriver driver;

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div#column-a")
	private WebElement blockA;

	@FindBy(xpath = "//div[@id='column-b']")
	private WebElement blockB;

	public void dragAndDropElement() throws AWTException {
		Actions actions = new Actions(driver);
		
		//actions.dragAndDrop(blockB, blockA).build().perform();
		
		Action move=actions.clickAndHold(blockA).moveToElement(blockB).release(blockB).build();
		move.perform();
		

		
	}
	
	@FindBy(css="div[id='column-a']>header")
	private WebElement blockHeader;
	
	public String verifyDragAndDrop() {
		return blockHeader.getText();
	}
}
