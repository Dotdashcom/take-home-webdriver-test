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
public class MouseHoverPage extends BasePage {

	public MouseHoverPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="(//*[@class='figure'])[2]")
	WebElement profileTwo;
	@FindBy(xpath="(//*[@class='figure'])[1]")
	WebElement profileOne;
	@FindBy(xpath="(//*[@class='figure'])[3]")
	WebElement profileThree;
	
	@FindBy(xpath="//*[contains(text(),'View profile')]")
	WebElement popUpCaptionOne;
	
	@FindBy(xpath="(//*[contains(text(),'View profile')])[2]")
	WebElement popUpCaptionTwo;
	
	@FindBy(xpath="(//*[contains(text(),'View profile')])[3]")
	WebElement popUpCaptionThree;
	
	
	
public boolean hoverOverElement(WebElement element,WebElement popedUpElement) throws Exception{
	Actions actions=new Actions(driver);
	actions.moveToElement(element).perform();
	
return 	popedUpElement.getText().equalsIgnoreCase("View profile");
	
	
}


	public boolean verifyHoverOver() throws Exception{
		return hoverOverElement(profileOne,popUpCaptionOne)&& hoverOverElement(profileTwo,popUpCaptionTwo)&& hoverOverElement(profileThree,popUpCaptionThree);
	}

}
