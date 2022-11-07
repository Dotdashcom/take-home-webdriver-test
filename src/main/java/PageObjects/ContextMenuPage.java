package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {

	@FindBy(how=How.ID,using="hot-spot")
	private WebElement searchContextMenu;
	
	public ContextMenuPage(WebDriver driver){
		PageFactory.initElements(driver,this);
		}
	public WebElement searchContextbox() {
		return searchContextMenu;
		
	}
	
}
