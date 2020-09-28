/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.WebLink;

/**
 * @author choudhuryIqbal
 *
 */
public class DynamicLoadingPage extends BasePage {

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id ="start")
	WebElement btn_start;
	
	@FindBy(id="finish")
	WebElement text;
	
public void clickStartButton() throws Exception{
	btn_start.click();
	
}
	
public void waitForTextElement(WebDriver driver) throws Exception{
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(text));
}

public boolean verifyTextElement() throws Exception{
	return text.getText().equalsIgnoreCase("Hello World!");
}
	


}
