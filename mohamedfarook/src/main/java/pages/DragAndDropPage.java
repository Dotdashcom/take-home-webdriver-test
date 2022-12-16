package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BaseClass {

	@FindBy(xpath = "//header[.='A']")
	public WebElement FirstColumn;

	@FindBy(xpath = "//header[.='B']")
	public WebElement SecondColumn;

	public DragAndDropPage() {
		PageFactory.initElements(driver, this);
	}

}