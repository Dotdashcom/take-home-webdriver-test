package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class DragAndDropPageFactory extends CommonMethods {
	
	@FindBy (id = "column-a")
	public WebElement box_a;
	
	@FindBy (id = "column-b")
	public WebElement box_b;
	
	@FindBy (id = "column-b")
	public WebElement box_b_text;
	
	public DragAndDropPageFactory() {
		PageFactory.initElements(driver, this);
	}

}
