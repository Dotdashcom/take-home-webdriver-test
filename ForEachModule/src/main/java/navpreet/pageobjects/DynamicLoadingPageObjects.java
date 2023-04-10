package navpreet.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPageObjects {

	WebDriver driver;
	WebDriverWait wait;

	public DynamicLoadingPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Dynamic Loading']")
	private WebElement click_loading;

	@FindBy(css = "a[href='/dynamic_loading/1']")
	private WebElement click_example;

	@FindBy(css = "div[id='start'] button")
	private WebElement click_start;

	@FindBy(css = "	div[id='finish'] h4")
	private WebElement see_message;

	public void ClickDynamicLoading() {
		click_loading.click();
	}

	public void ClickExample() {
		click_example.click();
	}

	public void ClickStart() {
		click_start.click();
	}

	public void ExplicitWaitForMessage() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
		wait.until(ExpectedConditions.visibilityOf(see_message));
	}

	public String GetMessage() {
		String text = see_message.getText();
		return text;
	}

}
