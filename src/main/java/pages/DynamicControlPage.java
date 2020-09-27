/**
 * 
 */
package pages;

import java.util.NoSuchElementException;

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
public class DynamicControlPage extends BasePage {

	public DynamicControlPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "(//*[contains(text(),'Remove')])[3]")
	WebElement btn_remove;

	@FindBy(xpath = "(//*[contains(text(),'Enable')])[3]")
	WebElement btn_enable;

	@FindBy(xpath = "(//*[contains(text(),'Disable')])[2]")
	WebElement btn_disable;

	@FindBy(xpath = "//*[@type='checkbox']")
	WebElement chkBox_checkBox;

	@FindBy(xpath = "//*[@id='message']")
	WebElement txt_Gone;
	@FindBy(xpath = "(//*[contains(text(),'Add')])[2]")
	WebElement btn_add;
	@FindBy(xpath = "//*[@id=\"message\"]")
	WebElement enabled_msg;

	public void clickRemove() {
		btn_remove.click();
	}

	public void clickAdd() {
		btn_add.click();
	}

	public void waitForElementToBevisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(chkBox_checkBox));
	}

	public boolean verifyChckBoxIsAdded() {
		clickAdd();
		waitForElementToBevisible(driver, chkBox_checkBox);
		if (chkBox_checkBox == null) {
			return false;
		} else
			return true;
	}

	public void enableTextBox() {
		btn_enable.click();
	}

	public void disableTextBox() {
		btn_disable.click();
	}

	public boolean verifyCheckBoxIsRemoved() {
		try {
			clickRemove();
			waitForElementToBeInvisible(driver, chkBox_checkBox);
			return txt_Gone.getText().equalsIgnoreCase("It's gone!");

		}

		catch (NoSuchElementException e) {
			return true;
		}
	}

	public void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public boolean verifyTextBoxIsEnabled() throws Exception {

		try {
			btn_enable.click();
			waitForElementToBevisible(driver, enabled_msg);

			return enabled_msg.getText().equalsIgnoreCase("It's enabled!");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	public boolean verifyTextBoxIsDisabled() throws Exception {

		try {
			btn_enable.click();
			waitForElementToBevisible(driver, enabled_msg);

			return enabled_msg.getText().equalsIgnoreCase("It's disabled!");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}
}
