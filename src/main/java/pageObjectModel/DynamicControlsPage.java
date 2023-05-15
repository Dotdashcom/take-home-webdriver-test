package pageObjectModel;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {
	private WebDriver driver;

	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//button[@onclick='swapCheckbox()']")
	private WebElement removeAddButton;
	
	@FindBy(how = How.XPATH, using = "//button[@onclick='swapInput()']")
	private WebElement enableButton;
	
	@FindBy(how = How.CSS, using ="p#message")
	private WebElement message;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private WebElement enableBox;

	
	public String clickRemoveAddButton() {
		removeAddButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(message));
		return message.getText();	
	}
	
	public boolean checkEnableBox() {	
		return enableBox.isEnabled();
	}
	
	public void clickEnableButton() {
		enableButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(message));
	}
	
}

