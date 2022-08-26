package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class JavaScriptAlertPage {

	WebDriver driver;

	public JavaScriptAlertPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'JavaScript Alerts')]")
	WebElement JAVASCRIPT_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Click for JS Alert')]")
	WebElement JSALERT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Click for JS Confirm')]")
	WebElement JSCONFIM_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Click for JS Prompt')]")
	WebElement JSPROMPT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//p[@id='result']")
	WebElement RESULT_ELEMENT;

	public void javaScriptAlertMenu() {
		JAVASCRIPT_MENU_ELEMENT.click();
	}

	public void javaAlertElement() throws InterruptedException {
		JSALERT_ELEMENT.click();
		Thread.sleep(2000);
		// switch to alert box and click on the OK button
		Alert alert = driver.switchTo().alert();
		alert.accept();

		String actualResult = "You successfuly clicked an alert";
		String expectedResult = RESULT_ELEMENT.getText();
		System.out.println("actual message: " + actualResult);
		System.out.println("expected message: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);

	}

	public void javaConfirmElement() throws InterruptedException {
		JSCONFIM_ELEMENT.click();
		Thread.sleep(2000);
		// switch to alert box and click on the OK button
		Alert alert = driver.switchTo().alert();
		alert.accept();

		String actualResult = "You clicked: Ok";
		String expectedResult = RESULT_ELEMENT.getText();
		System.out.println("actual message: " + actualResult);
		System.out.println("expected message: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	public void javaPromptElement() throws InterruptedException {
		JSPROMPT_ELEMENT.click();
		Thread.sleep(2000);
		// switch to alert box and click on the OK button
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello World");
		alert.accept();

		String actualResult = "You entered: Hello World";
		String expectedResult = RESULT_ELEMENT.getText();
		System.out.println("actual message: " + actualResult);
		System.out.println("expected message: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);

	}

}
