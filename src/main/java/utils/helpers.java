package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.io.File;
import java.io.IOException;

public class helpers {
	public WebDriver driver;
	public String ExecutionId;
	public String resultsLocation = "./target";
	public String screenshotsLocation = "";
	public static int screenshot_count = 1;
	public final static int MAX_TIMEOUT = 120;

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			throw new RuntimeException("Error occured while waiting for " + seconds + " seconds");
		}
	}

	public String generateRandomString(int length) {
		String input = RandomStringUtils.randomAlphabetic(length);
		return input;
	}

	public String generateRandomNumber(int length) {
		String input = RandomStringUtils.randomNumeric(length);
		return input;
	}

	public void generateExecutionId() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		ExecutionId = timeStamp.replace(".", "-");
	}

	public void createResultsLocation() {
		resultsLocation = resultsLocation + "\\" + ExecutionId;
		boolean bool = new File(resultsLocation).mkdirs();
		if (bool) {
			System.out.println("Results directory created successfully.");
		} else {
			throw new RuntimeException("Results directory isn’t created.");
		}
		screenshotsLocation = resultsLocation + "\\screenshots";
		bool = new File(screenshotsLocation).mkdirs();
		if (bool) {
			System.out.println("Screenshots directory created successfully.");
		} else {
			throw new RuntimeException("Screenshots directory isn’t created.");
		}
	}

	public void takeScreenshot() {
		File src = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(screenshotsLocation + "//screenshot_" + screenshot_count + ".png"));
			screenshot_count++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * getTitleOfWindow - to get current window title
	 */
	public String getTitleOfWindow() {
		return driver.getTitle();
	}
	
	/*
	 * refresh browser page 
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}


	public String getAlertMessage() {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(MAX_TIMEOUT));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	/*
	 * handleAlert - to accept or dismiss an Alert
	 */
	public void handleAlert(String action) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(MAX_TIMEOUT));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		if (action.equals("accept")) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		this.takeScreenshot();
	}

	/*
	 * handleAlertPrompt - to sendtext to alert and accept or dismiss the Alert
	 */
	public void handleAlert(String action, String value) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(MAX_TIMEOUT));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.sendKeys(value);
		if (action.equals("accept")) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		this.takeScreenshot();
	}

	public void click(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to perfrom Click on Element: " + by.toString());
		}
	}

	public void mouseHover(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to perfrom mouse hover on Element: " + by.toString());
		}

	}

	public void contextClick(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Actions action = new Actions(driver);
			action.moveToElement(element).contextClick().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to perfrom mouse hover on Element: " + by.toString());
		}
	}

	public boolean sendKeys(By by, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to send keys to Element: " + by.toString());
			return false;
		}
		return true;
	}
	
	public boolean sendKeys(By by, String value,boolean clear) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			if(clear)
				element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to send keys to Element: " + by.toString() + e);
			return false;
		}
		return true;
	}

	public boolean verifyCheckboxIsSelected(By by) {
		boolean selection = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			selection = element.isSelected();
			this.takeScreenshot();
		} catch (Exception e) {
			System.out.println("Unable to verify element is selected: " + by.toString());
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return selection;
	}

	public String getText(By by) {
		String value = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			value = element.getText();

		} catch (Exception e) {
			System.out.println("Unable to get text from Element: " + by.toString());
		}
		return value;
	}

	public boolean verifyBrowserConsoleLogs(String message) {
		LogEntries le = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : le) {
			if (entry.getMessage().contains(message)) {
				return true;
			}
		}
		return false;
	}

	public void switchToNextWindow() {
		String parentHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}

	}

	public boolean checkElementExists(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			System.out.println("Element is Not available: " + by.toString());
		}
		return false;
	}
	
	public boolean checkElementExists(By by, int timeinseconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeinseconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			System.out.println("Element is Not available: " + by.toString());
		}
		return false;
	}
	
	public boolean checkElementEnabled(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return element.isEnabled();
		} catch (Exception e) {
			System.out.println("Element is Not available: " + by.toString());
		}
		return false;
	}
	
	public boolean waitUntilElementInvisibility(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			System.out.println("Element is Not available: " + by.toString());
		}
		return false;
	}

	public void selectValueinLOV(By by, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select sel = new Select(element);
			sel.selectByVisibleText(value);
		} catch (Exception e) {
			throw new RuntimeException("Unable to select value for element: " + by.toString());
		}
	}
	
	public void switchToFrame(By by)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			driver.switchTo().frame(element);
		} catch (Exception e) {
			throw new RuntimeException("Unable to switch to frame: " + by.toString());
		}
	}

	public String getSelectedValueLOV(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select sel = new Select(element);
			WebElement option = sel.getFirstSelectedOption();
			return option.getText();
		} catch (Exception e) {
			throw new RuntimeException("Unable to select value for element: " + by.toString());
		}
	}
	
	public void scrollToElement(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOf(element));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println("Element is Not available: " + by.toString());
		}
	}
	
	public void dragAndDrop(By ele1, By ele2)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
			WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(ele1));
			wait.until(ExpectedConditions.visibilityOf(element1));
			WebElement element2 = wait.until(ExpectedConditions.presenceOfElementLocated(ele2));
			wait.until(ExpectedConditions.visibilityOf(element2));
			  Actions act=new Actions(driver);				
			  act.dragAndDrop(element1, element2).build().perform();
		} catch (Exception e) {
			System.out.println("Drag and Drop Failed: " + e);
		}
		this.takeScreenshot();
	}
}
