package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage {
	static WebDriver driver;

	public DynamicLoadingPage(WebDriver driver) {
		DynamicLoadingPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Start')]")
	WebElement START_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Hello World!')]")
	WebElement GENERATED_TEXT_ELEMENT;

//	Methods
	public void clickStartButton() {
		START_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void validateTextIsDisplayedAfterStartButtonIsClicked() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(GENERATED_TEXT_ELEMENT));
		Assert.assertEquals(GENERATED_TEXT_ELEMENT.getText(), "Hello World!", "The text does not macth!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
