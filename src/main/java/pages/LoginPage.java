package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	static WebDriver driver;

	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//input[@id = 'username']")
	WebElement USERNAME_INPUT_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'password']")
	WebElement PASSWORD_INPUT_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@type= 'submit']")
	WebElement LOGIN_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@id= 'flash']")
	WebElement LOGIN_SUCCESSFUL_FLASH_ALERT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Your username is invalid!')]")
	WebElement INVALID_USERNAME_FLASH_ALERT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Your password is invalid!')]")
	WebElement INVALID_PASSWORD_FLASH_ALERT_ELEMENT;

//	Methods
	public void loginWithValidUsernameAndPassword() {
		USERNAME_INPUT_BOX_ELEMENT.sendKeys("tomsmith");
		PASSWORD_INPUT_BOX_ELEMENT.sendKeys("SuperSecretPassword!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void loginWithInvalidUsername() {
		USERNAME_INPUT_BOX_ELEMENT.sendKeys("tomsmith123");
		PASSWORD_INPUT_BOX_ELEMENT.sendKeys("SuperSecretPassword!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void loginWithInvalidPassword() {
		USERNAME_INPUT_BOX_ELEMENT.sendKeys("tomsmith");
		PASSWORD_INPUT_BOX_ELEMENT.sendKeys("SuperSecretPassword!123");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoginButton() {
		LOGIN_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoginIsSuccessful() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(LOGIN_SUCCESSFUL_FLASH_ALERT_ELEMENT));
		Assert.assertTrue(element.isDisplayed(), "Login was not successful!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoginIsFailureForInvalidUsername() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(INVALID_USERNAME_FLASH_ALERT_ELEMENT));
		Assert.assertTrue(element.isDisplayed(), "Username must be invalid!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoginIsFailureForInvalidPassword() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(INVALID_PASSWORD_FLASH_ALERT_ELEMENT));
		Assert.assertTrue(element.isDisplayed(), "Password must be invalid!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
