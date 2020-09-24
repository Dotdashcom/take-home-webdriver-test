/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import base.WebLink;

/**
 * @author choudhuryIqbal
 *
 */
public class DynamicContentPage extends BasePage {

	public DynamicContentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id=\"content\"]/div[1]")
	WebElement contentOne;
	
	
	public void refreshPage() {
		driver.get(WebLink.dynamicContentPageUrl);
		driver.navigate().refresh();
		
	}
	
	public boolean verifyContentChange() {
		String firstText=contentOne.getText();
		refreshPage();
		return firstText.equalsIgnoreCase(contentOne.getText());
	}
	
	
}
