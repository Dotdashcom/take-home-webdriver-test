package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class DragandDrop extends BaseClass{
	@FindBy(xpath = "//div[@id ='column-a']")
	public WebElement box1;

	@FindBy(xpath = "//div[@id ='column-b']")
	private WebElement box2;

	public DragandDrop() {
		PageFactory.initElements(driver, this);
	}

	public void dragDrop() {
		Actions actions = new Actions(driver);
        actions.dragAndDrop(box1, box2).perform();
	}

}
