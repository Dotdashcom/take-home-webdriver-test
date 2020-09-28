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
public class IframePage extends BasePage {

	public IframePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id ="mce_0_ifr")
	WebElement textFrame;
	
	@FindBy(id="tinymce")
	WebElement textBox;
	
	
	

	public boolean verifyIframe() {
		// TODO Auto-generated method stub
		return textBox.getText().equalsIgnoreCase("some Text");
	}




	public void ChangeFrame() {
		// TODO Auto-generated method stub
		driver.switchTo().frame(textFrame);
		
	}




	public void EnterText() {
		// TODO Auto-generated method stub
		
		textBox.clear();
		textBox.sendKeys("some Text");
	}

}
