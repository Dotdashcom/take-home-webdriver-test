package navpreet.pageobjects;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPageObject {

	WebDriver driver;
	WebDriverWait wait;
	String message;

	public DynamicControlsPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Dynamic Controls']")
	private WebElement click_dynamicControls;

	@FindBy(xpath = "//form[@id='checkbox-example']/button")
	private WebElement clickRemoveAndAddButton;

	@FindBy(id = "message")
	private WebElement see_message;
	

	@FindBy(id="message")
	private WebElement checkboxMessage;

	@FindBy(css="input[type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath="//button[text()='Enable']")
	private WebElement enableButton;

	@FindBy(xpath="//button[text()='Disable']")
	private WebElement disableButton;

	@FindBy(xpath="//button[text()='Remove']")
	private WebElement removeButton;

	@FindBy(xpath="//button[text()='Add']")
	private WebElement addButton;
	
	@FindBy(id="message")
	private WebElement textboxMessage;

	@FindBy(css="input[type='text']")
	private WebElement textbox;

	public void ClickDynamicControls() {
		click_dynamicControls.click();
	}

	public void ExplicitWait(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String removeCheckbox() {
		removeButton.click();
		ExplicitWait(addButton);
		message=checkboxMessage.getText();
		return message;
	}

	public String addCheckbox() {
		addButton.click();
		ExplicitWait(removeButton);
		message=checkboxMessage.getText();
		return message;
	}

	public String enableTextBox() {
		enableButton.click();
		ExplicitWait(disableButton);
		message=checkboxMessage.getText();
		return message;
	}

	public String disableTextBox() {
		disableButton.click();
		ExplicitWait(enableButton);
		message=checkboxMessage.getText();
		return message;
	}

}
