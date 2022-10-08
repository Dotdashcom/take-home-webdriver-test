package framework;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObjectBase {
	private WebDriver driver;
	private String baseUrl;
	private Set<String> windowHandles;


	protected abstract String getRelativeUrl();

	protected PageObjectBase(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
	}

	public String getUrl() {
		return baseUrl + getRelativeUrl();
	}

	protected void navigateToRelativeUrl() {
		driver.navigate().to(getUrl());
	}

	protected WebElement waitForElementVisible(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element;
	}

	protected String getBaseUrl() {
		return this.baseUrl;
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected void switchToNewWindow(String currentWindowHandle) {
		this.windowHandles = this.getDriver().getWindowHandles();

		for(String windowHandle:windowHandles) {
			if(!windowHandle.equals(currentWindowHandle)) {
				this.getDriver().switchTo().window(windowHandle);
			}
		}
	}
}