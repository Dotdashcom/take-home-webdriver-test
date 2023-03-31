package dotDashcom.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {

	WebDriver driver;

	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//button[text()='Remove']")
	private WebElement removeButton;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement addButton;
	
	@FindBy(id="message")
	private WebElement checkboxMessage;
	
	@FindBy(css="input[type='checkbox']")
	private WebElement checkbox;
	
	public String removeCheckbox() {
		removeButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(checkboxMessage));
		return checkboxMessage.getText();
	}
	
	public String addCheckbox() {
		addButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		return checkboxMessage.getText();
		
	}
	
	@FindBy(xpath="//button[text()='Enable']")
	private WebElement enableButton;
	
	@FindBy(xpath="//button[text()='Disable']")
	private WebElement disableButton;
	
	@FindBy(id="message")
	private WebElement textboxMessage;
	
	@FindBy(css="input[type='text']")
	private WebElement textbox;
	
	public String enableTextBox() {
		enableButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(textbox)).isEnabled();
		return textboxMessage.getText();
	}
	
	public String disableTextBox() {
		disableButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(textboxMessage));
		return textboxMessage.getText();
	}
}
