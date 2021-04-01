package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.util.PageLinks;

public class DragAndDropPage extends BasePage {


	public DragAndDropPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "column-a")
	private WebElement columnA;
	
	@FindBy(id = "column-b")
	private WebElement columnB;
	
	@FindBy(id = "//div[@id='column-a']/header")
	private WebElement columnAHeader;
	
	@FindBy(id = "//div[@id='column-b']/header")
	private WebElement columnBHeader;
	
	public void verifyDragAndDrop() throws InterruptedException {
		WebDriver driver = getDriver();
		Actions actions = new Actions(driver);
		actions.dragAndDrop(columnA, columnB).release().build().perform();
	
		String columnATxt = columnAHeader.getText().trim();
		String columnBTxt = columnBHeader.getText().trim();
		assertEquals("A", columnBTxt);
		assertEquals("B", columnATxt);
	}
	
	public void visitDragAndDropPage() {
		getDriver().get(PageLinks.DRAG_DROP_PAGE);
	}
	
}
