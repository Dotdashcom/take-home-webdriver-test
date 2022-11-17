package utils;

import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProxyDriver implements WebDriver, JavascriptExecutor {
	private WebDriver driver;
	public static JavascriptExecutor js;
	public Actions action;


	public ProxyDriver(WebDriver wd) {
		driver = wd;
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);

	}

	@Override
	public Object executeScript(String script, Object... args) {

		return null;
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {

		return null;
	}

	@Override
	public void get(String url) {
		ProxyDriver.this.driver.get(url);

	}

	public void contextClick(By by) {

		action.contextClick(this.waitForElementToBeClickable(by, 5)).perform();
	}

	public void dragAndDrop(By by, By bye) {
		WebElement drag = this.waitForElementToBeClickable(by, 5);
		WebElement drop = this.waitForElementToBeClickable(bye, 5);


		js.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
						+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
						+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
						+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
						+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
						+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
						+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
						+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
						+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
						+ "var dragStartEvent =createEvent('dragstart');\n"
						+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
						+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
						+ "var dragEndEvent = createEvent('dragend');\n"
						+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
						+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
						+ "simulateHTML5DragAndDrop(source,destination);",
				drag, drop);

	}

	public void mouseHoverElement(By by) {
		WebElement element = this.waitForElementToBeClickable(by, 5);
		action.moveToElement(element).perform();
	}

	@Override
	public String getCurrentUrl() {
		return ProxyDriver.this.driver.getCurrentUrl();

	}

	@Override
	public String getTitle() {
		return ProxyDriver.this.driver.getTitle();

	}

	@Override
	public List<WebElement> findElements(By by) {
		return ProxyDriver.this.driver.findElements(by);

	}

	@Override
	public WebElement findElement(By by) {
		return ProxyDriver.this.driver.findElement(by);

	}

	@Override
	public String getPageSource() {
		return ProxyDriver.this.driver.getPageSource();

	}

	@Override
	public void close() {
		ProxyDriver.this.driver.close();

	}

	public void click(By locator) {
		this.waitForElementToBeClickable(locator, 10).click();
	}

	@Override
	public void quit() {
		ProxyDriver.this.driver.quit();

	}

	@Override
	public Set<String> getWindowHandles() {
		return ProxyDriver.this.driver.getWindowHandles();

	}

	@Override
	public String getWindowHandle() {
		return ProxyDriver.this.driver.getWindowHandle();

	}

	public String getText(By locator) {
		try {

			WebElement element = this.waitForElementToBeVisible(locator, 10);
			return element.getText().trim();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean printPageErrorsVerifyText(String text) {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		System.out.println("Javascript errors on page are:");
		for (LogEntry entry : logEntries) {
			System.out.println(entry.getMessage());
			if (entry.getMessage().contains(text)) {
				return true;
			}
		}
		return false;
	}

	public void sendKeys(By by, String keysInput) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(by)))
				.sendKeys(keysInput);
	}

	public void sendKeysAlert(By by, String keysInput) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent())
				.sendKeys(keysInput);
	}

	public boolean isDisplayed(By by) {
		try {
			waitForElementToBeVisible(by, 10);
			return this.findElement(by).isDisplayed();
		} catch (Exception e) {

		}
		return false;
	}

	public boolean isEnabled(By by) {
		try {
			waitForElementToBeVisible(by, 10);
			return this.findElement(by).isEnabled();
		} catch (Exception e) {

		}
		return false;
	}

	public boolean isSelected(By by) {
		try {
			waitForElementToBeVisible(by, 5);
			return this.findElement(by).isSelected();
		} catch (Exception e) {

		}
		return false;
	}

	public void selectFromDropDown(By by, String value) {
		WebElement element = waitForElementToBeVisible(by, 5);
		Select sc = new Select(element);
		try {
			sc.selectByValue(value);
		} catch (Exception e) {
			sc.selectByVisibleText(value);
		}
	}

	public String getselectedText(By by) {
		WebElement element = waitForElementToBeVisible(by, 5);
		Select sc = new Select(element);
		return sc.getFirstSelectedOption().getText();
	}

	public List<WebElement> isElementsDisplayed(By by) {
		return new WebDriverWait(driver, 15)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	public String[] textOfElements(By by) {
		List<WebElement> partial = isElementsDisplayed(by);
		String[] texts = new String[partial.size()];
		for (int i = 0; i < partial.size(); i++) {
			texts[i] = partial.get(i).getText();
		}
		return texts;
	}

	public void switchToNewTab(By element) {
		String parentHandle = this.getWindowHandle();
		waitForElementToBeClickable(element, 5);

		Set<String> allWindowHandles = this.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentHandle)) {
				this.switchTo().window(windowHandle);
			}
		}

	}

	public void scrollIntoViewUsingJavascript(By by) {

		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
		click(by);
	}

	public void scrollDownUsingJavaScript() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void acceptAlert() {
		new WebDriverWait(this, 15).until(ExpectedConditions.alertIsPresent()).accept();
	}

	public String alertText() {
		return new WebDriverWait(this, 15).until(ExpectedConditions.alertIsPresent()).getText();

	}

	public void dismissAlert() {
		new WebDriverWait(this, 10).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public WebElement waitForElementToBeClickable(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this, 10).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementToBeVisible(By Locator, int timeOutInSeconds) {
		return new WebDriverWait(this, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}

	public void waitForElementToBeSelectable(WebElement element) {
		new WebDriverWait(this, 10)
				.until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

	public void submit(By by) {
		waitForElementToBeClickable(by, 15).submit();

	}

	@Override
	public TargetLocator switchTo() {

		return ProxyDriver.this.driver.switchTo();
	}

	public Navigation navigate() {
		return new Navigation() {

			public void to(URL url) {
				ProxyDriver.this.driver.navigate().to(url);

			}

			public void to(String url) {
				ProxyDriver.this.driver.navigate().to(url);

			}

			public void refresh() {
				ProxyDriver.this.driver.navigate().refresh();

			}

			public void forward() {
				ProxyDriver.this.driver.navigate().forward();

			}

			public void back() {
				ProxyDriver.this.driver.navigate().back();

			}
		};
	}

	@Override
	public Options manage() {

		return ProxyDriver.this.driver.manage();
	}

}

