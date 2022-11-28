package Browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BaseTest;

public class BrowserUtilities extends BaseTest {

	// move to a specific element in the webpage.
	public static void MoveMouse(WebDriver driver, WebElement element) {
		if (isElementPresent(element)) {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} else {
			System.out.println("Element doesn't exists in this page");
			// ExtentTestManager.getTest().log(LogStatus.FAIL,element.getText()+"doesn't
			// exist in this page");

		}
	}

	// Check if element present in the webpage
	public static Boolean isElementPresent(WebElement elementDesc) {
		Boolean elementStatus = false;
		int timeOutInSeconds = 20;
		boolean staleElement;
		do {
			try {
				WebDriverWait wait = new WebDriverWait(BaseTest.driver, timeOutInSeconds);
				Actions actions = new Actions(BaseTest.driver);
				actions.moveToElement(elementDesc).perform();
				WebElement weObj = wait.until(ExpectedConditions.elementToBeClickable(elementDesc));
				if (!weObj.getSize().equals(0))
					elementStatus = true;
				staleElement = false;
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale");
				staleElement = true;
			} catch (Exception e) {
				// ExtentTestManager.getTest().log(LogStatus.FAIL, e.getMessage());
				e.printStackTrace();
				staleElement = false;
			}
		} while (staleElement);
		return elementStatus;
	}

	// Check if element present in the webpage by passing the string name
	public static Boolean isElementPresent(WebElement element, String desc) {
		Boolean elementStatus = false;
		int timeOutInSeconds = 20;
		boolean staleElement;
		do {
			try {
				WebDriverWait wait = new WebDriverWait(BaseTest.driver, timeOutInSeconds);
				WebElement weObj = wait.until(ExpectedConditions.elementToBeClickable(element));

				if (!weObj.getSize().equals(0))
					elementStatus = true;
				staleElement = false;
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale");
				staleElement = true;
			} catch (Exception e) {
				// ExtentTestManager.getTest().log(LogStatus.FAIL."Element" +desc+ "is not
				// present on the page");
				// ExtentTestManager.getTest().log(LogStatus.FAIL, e.getMessage());
				e.printStackTrace();
				staleElement = false;
			}
		} while (staleElement);
		return elementStatus;
	}

	// To click a webELement
	public static void Click(WebElement element) {
		if (BrowserUtilities.isElementPresent(element)) {
			WebElement waitElement = fnExplictWaitOfElement(BaseTest.driver, element);
			waitElement.click();
			BrowserUtilities.fnExplictsleep(1000);
		} else {
			BaseTest.log4j.info("Element is not present on the page");
			// ExtentTestManager.getTest().log(LogStatus.FAIL, "ELement "+desc+"is not
			// present on the page");
		}
	}

	private static void fnExplictsleep(int time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static boolean fnSetTextInTextBox(String srcText, String textBoxDesc, WebElement elementDesc) {
		if (!isElementPresent(elementDesc)) {
			// ExtentTestManager.getTest().log(LogStatus.FAIL, "Text Box '" + textBoxDesc +
			// "'not located");
			return false;
		} else {
			// ExtentTestManager.getTest().log(LogStatus.PASS, "Text Box '" + textBoxDesc +
			// "' located");
			elementDesc.sendKeys(srcText);
			elementDesc.sendKeys(Keys.TAB);
			// ExtentTestManager.getTest().log(LogStatus.PASS, "Text '" + srcText +
			// "'entered in Text Box" + textBoxDesc+ "'");
			return true;
		}
	}

	// Function to click button
	public static void fnClickButton(WebElement elementDesc) {
		if (!isElementPresent(elementDesc)) {
			// ExtentTestManager.getTest().log(LogStatus.FAIL, "Text Box '" + textBoxDesc +
			// "'not located");
			System.out.println("not located");
		} else {
			Actions actions = new Actions(BaseTest.driver);
			actions.moveToElement(elementDesc).perform();
			// ExtentTestManager.getTest().log(LogStatus.PASS, "Button is located");
			WebElement element = BrowserUtilities.fnExplictWaitOfElement(BaseTest.driver, elementDesc);
			element.click();
			// ExtentTestManager.getTest().log(LogStatus.PASS, "Button is clicked");
			BrowserUtilities.fnImplicitWait(20);
		}

	}

	public static void fnRightClickButton(WebElement elementDesc) {
		if (!isElementPresent(elementDesc)) {
			// ExtentTestManager.getTest().log(LogStatus.FAIL, "Text Box '" + textBoxDesc +
			// "'not located");
			System.out.println("not located");
		} else {
			Actions actions = new Actions(BaseTest.driver);
			actions.contextClick(elementDesc).perform();
			BrowserUtilities.fnImplicitWait(20);
		}

	}
	/*public static void fnalert(WebElement elementDesc) {
		if (!isElementPresent(elementDesc)) {
			// ExtentTestManager.getTest().log(LogStatus.FAIL, "Text Box '" + textBoxDesc +
			// "'not located");
			System.out.println("element not located");
		} else {
			elementDesc.click();
			driver.switchTo().alert().getText();
		}

	}*/

	public static void fndragAndDrop(WebElement draggable, WebElement droppable) {
		if (!isElementPresent(draggable)) {

			// ExtentTestManager.getTest().log(LogStatus.FAIL, "Text Box '" + textBoxDesc +
			// // "'not located");
			System.out.println("draggable element not located");
		} else if (!isElementPresent(droppable)) {
			System.out.println("droppable element not located");

		} else {
			Actions actions = new Actions(BaseTest.driver);
			actions.dragAndDrop(draggable, droppable).build().perform();

			// ExtentTestManager.getTest().log(LogStatus.PASS, "Button is clicked");
			BrowserUtilities.fnImplicitWait(20);
		}

	}

	// click a webelement using javascript executor
	public static void fnClickWebElement(WebElement elementDesc) {
		if ((new WebDriverWait(BaseTest.driver, 20))
				.until(ExpectedConditions.elementToBeClickable(elementDesc)) == null) {
			// ExtentTestManager.getTest().log(LogStatus.FAIL, "Text Box '" + textBoxDesc +
			// "'not located");
			System.out.println("Element is not located");
		} else {
			JavascriptExecutor Executor = (JavascriptExecutor) BaseTest.driver;
			Executor.executeScript("arguments[0].scrollIntoView(true);", elementDesc);
			elementDesc.click();
		}

	}

	// getting text
	public String getText(WebElement element) {
		// if (isElementPresent(element))
		// return element.getText();
		/*
		 * else { //ExtentTestManager.getTest().log(LogStatus.FAIL,
		 * "element is not present or doesn't have the attribute value"); return null; }
		 */
		JavascriptExecutor Executor = (JavascriptExecutor) BaseTest.driver;
		Executor.executeScript("arguments[0].scrollIntoView(true);", element);
		return element.getText();
	}

	// select value from a dropdown using visible text
	public static boolean fnSelectValueFromDropdown(String dropdownSrcText, WebElement elementDesc) {
		if (!isElementPresent(elementDesc)) {
			// ExtentTestManager.getTest().log(LogStatus.FAIL, "Dropdown '" + textBoxDesc +
			// "'not located");
			System.out.println("not located");
			return false;
		} else {
			// ExtentTestManager.getTest().log(LogStatus.PASS, "Dropdown '" + buttonDesc +
			// "' located");
			Select dropdown = new Select(elementDesc);
			dropdown.selectByVisibleText(dropdownSrcText);
			// ExtentTestManager.getTest().log(LogStatus.PASS, "Value '" + dropdownSrcText +
			// "'select in ")+ dropdownDesc + "drop down");
			return true;
		}
	}

	// select value from a dropdown using index
	public static boolean fnSelectValueFromDropdown(int index, String dropdownDesc, WebElement elementDesc) {
		if (!isElementPresent(elementDesc)) {
			// ExtentTestManager.getTest().log(LogStatus.FAIL, "Drop down '" + textBoxDesc +
			// "'not located");
			System.out.println("not located");
			return false;
		} else {
			// ExtentTestManager.getTest().log(LogStatus.PASS, "Drop down '" + buttonDesc +
			// "' located");
			Select dropdown = new Select(elementDesc);
			dropdown.selectByIndex(index);
			// ExtentTestManager.getTest().log(LogStatus.PASS, "Value '" + dropdownSrcText +
			// "'select in ")+ dropdownDesc + "drop down");
			return true;
		}
	}

	protected static void fnImplicitWait(int time) {
		try {
			BaseTest.driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			// ExtentTestManager.getTest().log(LogStatus.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	protected static WebElement fnExplictWaitOfElement(WebDriver driver, WebElement element) {
		// TODO Auto-generated method stub
		WebElement element1 = null;
		WebDriverWait wait = new WebDriverWait(driver, 25);
		element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
		// ExtentTestManager.getTest().log(LogStatus.PASS, elementName+ " is
		// clickable.");
		return element1;
	}
	

}
