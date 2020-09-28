/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

/**
 * @author choudhuryIqbal
 *
 */
public class OpenNewTabPage extends BasePage {

	public OpenNewTabPage(WebDriver driver) throws Exception {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[contains(text(),'Click Here')]")
	WebElement clickHere;

	public Object hasNewWindowOpened() throws Exception {
		// TODO Auto-generated method stub

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		return driver.getTitle().equalsIgnoreCase("New Window");
	}

	public void clickOpenNewTab() throws Exception {
		// TODO Auto-generated method stub
		clickHere.click();
	}
}
