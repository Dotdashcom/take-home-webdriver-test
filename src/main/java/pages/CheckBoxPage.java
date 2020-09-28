/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.WebLink;

/**
 * @author choudhuryIqbal
 *
 */
public class CheckBoxPage extends BasePage {

	public CheckBoxPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
	WebElement checkBoxOne;

	@FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
	WebElement checkBoxTwo;

	public void clickCheckBoxOne() throws Exception{
		checkBoxOne.click();
	}

	public void clickCheckBoxTwo() throws Exception{
		checkBoxTwo.click();
	}

	public boolean isFirstBoxChecked() throws Exception{
		return checkBoxOne.isSelected();
	}

	public boolean isSecondBoxChecked() throws Exception {
		return checkBoxTwo.isSelected();
	}

	public void getCheckBoxURL() throws Exception{
		driver.get(WebLink.checkBoxUrl);
	}
}
