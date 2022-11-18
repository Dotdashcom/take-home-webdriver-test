package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.WebHelper;

public class DragAndDropPage {

private WebDriver driver;
private WebHelper helper;
	
	public DragAndDropPage(WebDriver driver, WebHelper helper) {		
		this.driver = driver;
		this.helper=helper;
	}
	
	private By dragElement = By.cssSelector("#column-a header");
	private By dropElement = By.cssSelector("#column-b header");
	
	public String GetTextForDragElement() {
		return driver.findElement(dragElement).getText();
	}
	
	public String GetTextForDropElement() {
		return driver.findElement(dropElement).getText();
	}
	
	public void DragAndDrop() throws InterruptedException {		
		
		helper.DragAndDrop(driver.findElement(dragElement), driver.findElement(dropElement));
	}
	
	public Boolean BooleanValueIfBlocksAreSwitched() {
		if (GetTextForDragElement().contains("B") && GetTextForDropElement().contains("A")){
			return true;
		}
		
		return false;
	}
	
	public void VerifyIfBlocksAreSwitched() {
		Assert.assertTrue(BooleanValueIfBlocksAreSwitched());
	}
	
	
}
