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
public class DropDownPage extends BasePage {

	public DropDownPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id ="dropdown")
	WebElement dropDown;
	
	
	public void selectByVisibleText(String text) {
		driver.get(WebLink.dropDownPageUrl);
		Select sel=new Select(dropDown);
		sel.selectByVisibleText(text);
	}
	
	
	public boolean verifyDropDownOption(String text) {
		Select sel=new Select(dropDown);
		WebElement option = sel.getFirstSelectedOption();
		String selectedText=option.getText();
		return text.equalsIgnoreCase(selectedText);
	
	}

}
