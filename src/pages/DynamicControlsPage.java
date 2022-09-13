package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.TestBase;

public class DynamicControlsPage extends TestBase{
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	WebElement RemoveButton;
	@FindBy(id="checkbox")
	WebElement CheckBox;
	@FindBy(xpath="//input[@id='checkbox']")
	WebElement CheckBoxReturn;
	@FindBy(xpath="//p[@id='message']")
	WebElement Message;
	@FindBy(xpath="//button[@onclick='swapCheckbox()']")
	WebElement AddButton;
	@FindBy(xpath="//button[contains(text(),'Enable')]")
	WebElement EnableButton;
	@FindBy(xpath="//button[@onclick='swapInput()']")
	WebElement DisableButton;

	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/dynamic_controls");
		
	}
	public void removeCheckBox() {
		CheckBox.isDisplayed();
		RemoveButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(AddButton));
	}
	public String VerifyCheckBoxRemoved() {
		return Message.getText();
	}
	public void clickOnAdd() {
		AddButton.isDisplayed();
		AddButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(RemoveButton));
	}
	public String VerifyCheckBoxPresent() {
		return Message.getText();
	}
	public void clickOnEnable() {
		EnableButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(DisableButton));
	}
	public String VerifyTextBoxEnabled() {
		return Message.getText();
	}
	public void clickOnDisable() {
		DisableButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(EnableButton));
	}
	public String VerifyTextBoxDisabled() {
		return Message.getText();
	}
	public void closeBrowser() {
		driver.quit();
	}
}
