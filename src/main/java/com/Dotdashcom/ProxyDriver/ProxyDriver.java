package com.Dotdashcom.ProxyDriver;

import java.net.URL;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProxyDriver implements WebDriver, JavascriptExecutor {
	private WebDriver driver;
	public Actions action;
	public static JavascriptExecutor jse;
	
	public ProxyDriver(WebDriver wd) {
		driver = wd;
		action = new Actions(driver);
		jse = (JavascriptExecutor) driver;
	}

	public String getText(By Locator) {
		return this.getText(Locator, 5);
	}

	public void click(By locator) {
		this.waitForElementToBeClickable(locator, 15).click();
	}

	public void submit(By locator) {
		this.waitForElementToBeClickable(locator, 5).submit();
	}

	public Object executeScript(String script, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object executeAsyncScript(String script, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	public void get(String url) {
		ProxyDriver.this.driver.get(url);

	}

	public String getCurrentUrl() {
		return ProxyDriver.this.driver.getCurrentUrl();
	}

	public String getTitle() {
		return ProxyDriver.this.driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		return ProxyDriver.this.driver.findElements(by);
	}

	public WebElement findElement(By by) {
		return ProxyDriver.this.driver.findElement(by);
	}

	public String getPageSource() {
		return ProxyDriver.this.driver.getPageSource();
	}

	public void close() {
		driver.close();

	}

	public void quit() {
		driver.quit();

	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
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

	public String getText(By locator, int waitforElementToBeVisibleInSeconds) {
		try {

			WebElement element = this.waitForElementToBeVisible(locator, waitforElementToBeVisibleInSeconds);
			return element.getText().trim();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String[] getTexts(By locator, int waitforElementToBeVisibleInSeconds) {
		try {
			List<WebElement> elements = this.driver.findElements(locator);
			String[] errormessages = null;
			int i = 0;
			for (WebElement element : elements) {
				this.waitForElementToBeVisible(element);
				errormessages[i] = element.getText().trim();
				i++;
			}
			return errormessages;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void waitForElementToBeVisible(WebElement element) {
		// TODO Auto-generated method stub

	}
	
	public void scrollIntoViewUsingJavascript(By by) {

		jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
		click(by);
	}

	public void scrollDownUsingJavaScript() {
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public Options manage() {
		return driver.manage();
	}

	public void sendKeys(By by, String keysInput) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(by)))
				.sendKeys(keysInput);
	}

	public boolean isDisplayed(By by) {
		try {
			waitForElementToBeVisible(by, 10);
			return this.findElement(by).isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean isEnabled(By by) {
		try {
			waitForElementToBeVisible(by, 10);
			return this.findElement(by).isEnabled();
		} catch (Exception e) {
			// TODO: handle exception
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
		Select sc = new Select( waitForElementToBeVisible(by, 5));
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
	
	public void moveToElement(By by) {
		WebElement element = this.waitForElementToBeClickable(by, 5);
		action.moveToElement(element).perform();
	}
	public void contextClick(By by) {

		action.contextClick(this.waitForElementToBeClickable(by, 5)).perform();
	}
	
	public String textFromAlert() {
		
		return new WebDriverWait(this, 5).until(ExpectedConditions.alertIsPresent()).getText();

	}

	public void acceptAlert() {
		
		new WebDriverWait(this, 15).until(ExpectedConditions.alertIsPresent()).accept();
	}

	public void dismissAlert() {
		new WebDriverWait(this, 15).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public WebElement waitForElementToBeClickable(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this,timeOutInSeconds)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementToBeVisible(By Locator, int timeOutInSeconds) {
		return new WebDriverWait(this,timeOutInSeconds)
				.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}

	public void waitForElementToBeSelectable(WebElement element) {
		new WebDriverWait(this, 15)
				.until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

	public void dragAndDrop(By aBox, By bBox) {
		WebElement drag = this.waitForElementToBeClickable(aBox, 5);
		WebElement drop = this.waitForElementToBeClickable(bBox, 5);
		jse.executeScript(
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
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

		}
	}
	public boolean verifyErrorText(String text) {
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

}
