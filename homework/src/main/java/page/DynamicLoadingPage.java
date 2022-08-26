package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage {

	WebDriver driver;

	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Dynamic Loading')]")
	WebElement DYNAMIC_LOADING_ELEMENT;

	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/dynamic_loading/1')]")
	WebElement EXAMPLE1_ELEMENT;

	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/dynamic_loading/2')]")
	WebElement EXAMPLE2_ELEMENT;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Start')]")
	WebElement START_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"finish\"]/h4")
	WebElement HELLOMESSAGE_ELEMENT;

	public void dynamicLoadingMenu() {
		DYNAMIC_LOADING_ELEMENT.click();
	}

	public void clickExample1() {

		EXAMPLE1_ELEMENT.click();
		START_ELEMENT.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(HELLOMESSAGE_ELEMENT));

		String actualMessage = "Hello World!";
		String expectedTitle = HELLOMESSAGE_ELEMENT.getText();
		System.out.println("actual: " + actualMessage);
		System.out.println("expected: " + expectedTitle);
		Assert.assertEquals(actualMessage, expectedTitle);

	}

	public void clickExample2() {

		EXAMPLE2_ELEMENT.click();
		START_ELEMENT.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(HELLOMESSAGE_ELEMENT));

		String actualMessage = "Hello World!";
		String expectedTitle = HELLOMESSAGE_ELEMENT.getText();
		System.out.println("actual: " + actualMessage);
		System.out.println("expected: " + expectedTitle);
		Assert.assertEquals(actualMessage, expectedTitle);

	}

}
