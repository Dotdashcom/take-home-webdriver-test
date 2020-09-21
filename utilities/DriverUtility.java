package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import core.Base;

public class DriverUtility extends Base {

	public static boolean isSelected(WebElement ele) {

		if (ele.isSelected()) {
			return true;
		} else {
			return false;
		}

	}

	public static void SelectByIndex(WebElement ele, int index) {
		Select select = new Select(ele);
		select.selectByIndex(index);

	}

	public static void clickonElement(WebElement ele) {

		ele.click();

	}

	public static void enterText(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void waitforAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitForElement() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void wait(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void moveToElementAction(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();

	}

	public static boolean isElementEnabled(WebElement ele) {
		if (ele.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public static void switchToWindow() {

		Set<String> WindowsHandles = driver.getWindowHandles();
		Iterator<String> it = WindowsHandles.iterator();

		String window = it.next();
		driver.switchTo().window(window);

	}

	public static void clearTextUsingSendKeys(WebElement ele) {
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);

	}

}
