package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class DynamicControlPage extends BrowserUtilities {
	public DynamicControlPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	WebElement bt_checkBox;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Remove')]")
	WebElement btn_remove;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
	WebElement btn_add;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Disable')]")
	WebElement btn_disable;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Enable')]")
	WebElement btn_enable;
	
	@FindBy(how = How.XPATH, using = "//p[@id='message']")
	WebElement msg_Status;
	
	
	public void getUrl() {
		driver.get(BaseTest.getURL("dynamic_controls"));
	}
	public void clickCheckBox() {
		Click(bt_checkBox);
	}
	public void clickRemoveButton() {
		Click(btn_remove);
	}
	public void clickAddButton() {
		Click(btn_add);
	}
	public String getCheckBoxMessage() {
		return getText(msg_Status);
	}
	public void explicitWaitOfElementMessageCheckbox() {
		fnExplictWaitOfElement(driver,msg_Status);
	}
	public void clickEnableTextBox() {
		Click(btn_enable);
	}
	public void clickDisableTextBox() {
		Click(btn_disable);
	}
}
