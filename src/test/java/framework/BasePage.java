package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

//	public static WebElement webAction(WebDriver driver, final WebElement locator) {
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(15, TimeUnit.SECONDS)
//				.pollingEvery(1, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class)
//				.ignoring(StaleElementReferenceException.class)
//				.ignoring(ElementNotFoundException.class)
//				.withMessage(
//						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");
//
//		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(toByVal(locator));
//			}
//		});
//
//		return element;
//	}

	public void clickOnElement(WebDriver driver, WebElement locator, String successMessage, String failureMessage) {
		WebElement web = null;
		boolean found = false;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 150000) {
			try {
				try {
					locator.click();
				} catch (Exception e) {
					e.printStackTrace();
					JSClick(locator);
				}
				found = true;
				break;
			} catch (NoSuchElementException e1){
				System.out.println("No Such Element Exception: " + failureMessage);
				Assert.fail("No Such Element Exception: " + failureMessage);
			} catch (ElementNotVisibleException e2) {
				System.out.println("Element Not Visible Exception: " + failureMessage);
				Assert.fail("Element Not Visible Exception: " + failureMessage);
			} catch (StaleElementReferenceException sere) {
				clickOnElement(driver, locator, successMessage, failureMessage);
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		String foundSuccess = " :: Element found after waiting for " + totalTime + "milliseconds";
		if (found) {
			System.out.println(successMessage + foundSuccess);
		} else {
			System.out.println("Failed to find element after " + totalTime + "milliseconds");
		}
	}

	public void setValue(WebDriver driver, WebElement locator, String value) {
		try {
			waitUntilElementIsPresent(driver, locator);
			locator.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTextFromElement(WebDriver driver,WebElement locator) {
		return locator.getText();
	}

	public void waitUntilElementIsPresent(WebDriver driver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(toByVal(locator)));
	}

	public void waitUntilElementIsVisible(WebDriver driver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	public boolean isElementPresent(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
			if (element.isDisplayed() && element.isEnabled()){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}


	public boolean isElementSelected(WebDriver driver, WebElement locator) {
		return locator.isSelected();
	}

	public static By toByVal(WebElement element) {
		String stringElement = element.toString();
		String[] splitElement = stringElement.split(" ");
		String locatorType = splitElement[6].replace(":", "");
		String locatorPath = null;
		if(locatorType.equalsIgnoreCase("xpath")) {
			locatorPath = stringElement.substring(stringElement.indexOf("//"), stringElement.length() -1);
		} else {
			locatorPath = splitElement[7].substring(0, splitElement[7].length() - 1);
		}
		switch (locatorType) {
			case "xpath":
				return By.xpath(locatorPath);
			case "css selector":
				return By.cssSelector(locatorPath);
			case "id":
				return By.id(locatorPath);
			case "tag name":
				return By.tagName(locatorPath);
			case "name":
				return By.name(locatorPath);
			case "link text":
				return By.linkText(locatorPath);
			case "class name":
				return By.className(locatorPath);
		}
		return (By) element;
	}

	public void rightClick (WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement from, WebElement to) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(from, to).build().perform();
	}

	public void selectFromDropdown(WebDriver driver, String dropdownText, WebElement element) {
		Select selectElement = new Select(element);
		//select element by visible text
		selectElement.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(WebDriver driver, WebElement element, int index) {
		Select selectElement = new Select(element);
		//select element by index
		selectElement.selectByIndex(index);
	}

	public void selectFromDropdown(WebDriver driver, WebElement element, String value) {
		Select selectElement = new Select(element);
		//select element by value
		selectElement.selectByValue(value);
	}

	public String getSelectedOptionFromDropdown(WebDriver driver, WebElement element) {
		Select selectElement = new Select(element);
		//select element by value
		String text = selectElement.getFirstSelectedOption().getText();
		return text;
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void alertAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Accepted alert");
	}

	public void alertSendKeys(WebDriver driver, String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		System.out.println("Entered text into alert window");
	}

	public void switchToChildWindow(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles) {
			if(!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Switched to Child window");
			}
		}
	}

	public void JSClick (WebElement locator) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", locator);
	}
}
