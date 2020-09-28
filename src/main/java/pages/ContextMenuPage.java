/**
 * 
 */
package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.WebLink;

/**
 * @author choudhuryIqbal
 *
 */
public class ContextMenuPage extends BasePage {

	public ContextMenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\"hot-spot\"]")
	WebElement contextOption;


	public void invokeAlert() throws Exception {
		driver.get(WebLink.contextPageUrl);
		// TODO Auto-generated method stub
		Actions action = new Actions(driver).contextClick(contextOption);
		action.build().perform();
		
	}


	public boolean verifyAlertText() throws Exception {
		// TODO Auto-generated method stub
		String expected="You selected a context menu";
		Alert alert=driver.switchTo().alert();
		return alert.getText().equalsIgnoreCase(expected);
		
	}
}
