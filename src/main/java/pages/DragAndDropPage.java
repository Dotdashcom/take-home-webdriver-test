/**
 * 
 */
package pages;

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
public class DragAndDropPage extends BasePage {

	public DragAndDropPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath ="//*[@id=\"columns\"]//div")
	WebElement elementA;
	
	
	@FindBy(xpath ="(//*[@id=\"columns\"]//div)[2]")
	WebElement elementB;
	public void moveElement() {
		Actions act=new Actions(driver);
		act.dragAndDrop(elementA, elementB).build().perform();
	
		
	}
	
	public boolean verifyTextSwitch() {
		driver.get(WebLink.dragAndDropPageUrl);
		String textBoxOne=elementA.getText();
		String textBoxTwo=elementB.getText();
		moveElement();
		if(elementA.getText().equalsIgnoreCase(textBoxTwo)&& elementB.getText().equalsIgnoreCase(textBoxOne)) {
			return true;
		}
		else {
			return false;
		}
	}


}
