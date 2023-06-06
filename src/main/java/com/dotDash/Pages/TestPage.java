package com.dotDash.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.LogEntry;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage {
	WebDriver driver;

	// WebElements
	// 3. Check box1
	@FindBy(xpath = "//body//div//div[@class='example']//input[@type='checkbox'][1]")
	WebElement checkbox1;

	@FindBy(xpath = "//div[@class='example']//input[@type='checkbox'][2]")
	WebElement checkbox2;

	// 4. Context Menu
	@FindBy(xpath = "//div[@oncontextmenu='displayMessage()']")
	// @FindBy(xpath = "div[@style='border-style: dashed; border-width: 5px; width:
	// 250px; height: 150px;']")
	WebElement contextMenu;

	// Initializing the PO
	public TestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Test Methods
	// Test 3 : check box
	public boolean isChecked(WebElement boxElement) {
		String checkedAttribute = boxElement.getAttribute("checked");
		// below condition will give true when the checkbox is checked.
		boolean isChecked = checkedAttribute != null && checkedAttribute.equals("true");
		return isChecked;
	}

	// Test4: Context menu

	public String closeAlert() {
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		alert.accept();
		return alertMsg;

	}

	public void rightClickOnContextMenu() {
		// WebElement contextMen=driver.findElement(By.id("hot-spot"));
		Actions actions = new Actions(driver);
		// Perform right-click action
		actions.moveToElement(contextMenu);
		actions.contextClick(contextMenu).build().perform();
		// contextMenu.click();

		// Alert msg
		String alertText = closeAlert();
		System.out.println(alertText);
	}

	public void verifyCheckbox(String box) {

		if (box.equalsIgnoreCase("box1")) {
			verifyCheckboxClick(checkbox1, box);

		} else if (box.equalsIgnoreCase("box2")) {
			verifyCheckboxClick(checkbox2, box);

		}

	}

	private void verifyCheckboxClick(WebElement boxElement, String box) {
		// TODO Auto-generated method stub
		if (isChecked(boxElement)) {
			Assert.assertTrue(isChecked(boxElement), "Checkbox is checked.");
			System.out.println(box + " Checkbox is checked !!!!!");
		} else {

			Assert.assertFalse(isChecked(boxElement), "Checkbox is not checked.");
			System.out.println(box + " Checkbox is not checked !!!!!");

		}
	}

	public void clickCheckbox(String box) {
		if (box.equalsIgnoreCase("box1")) {

			clickCheckbox(checkbox1);
		} else if (box.equalsIgnoreCase("box2")) {

			clickCheckbox(checkbox2);
		}
	}

	private void clickCheckbox(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	// Test5: Drag and Drop
	public void dragAndDrop() {

		WebElement elementA = driver.findElement(By.xpath("//div[@class='column' and @id='column-a']"));
		WebElement elementB = driver.findElement(By.xpath("//div[@class='column' and @id='column-b']"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(elementA, 20, 0).build().perform();
		// actions.clickAndHold(elementA).moveToElement(elementB).release(elementB).build().perform();

		// actions.clickAndHold(elementA).moveToElement(elementB).build();
		// actions.dragAndDrop(elementA, elementB).perform();
		// actions.moveToElement(elementA).clickAndHold(elementA)

		// .moveToElement(elementB).pause(100).release(elementA)
		// .build().perform();
		// actions.moveToElement(elementA).clickAndHold(elementA).moveToElement(elementB).release(elementA).build().perform();
		// actions.dragAndDrop(elementA, elementB).build().perform();
	}

	// Test6. Contest change with reload

	public void contentBeforeAndAfterReload() throws InterruptedException {
		List<WebElement> elementBeforeReload = driver.findElements(By.xpath("//div[@class='large-10 columns']"));

		List<String> beforeReloadTextList = new ArrayList<>();
		for (WebElement element : elementBeforeReload) {
			beforeReloadTextList.add(element.getText());
		}

		// reload page
		driver.navigate().refresh();

		// After relaod elements

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20));
		List<WebElement> elementAfterReload = wait.until(ExpectedConditions
				.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='large-10 columns']"))));

		List<String> afterReloadTextList = new ArrayList<>();
		for (WebElement element : elementAfterReload) {
			afterReloadTextList.add(element.getText());
		}

		// compare 2 lists
		if (elementBeforeReload.equals(elementAfterReload)) {
			System.out.println("Content is equal Before and After reload");
		} else {
			System.out.println("Content is NOT equal Before and After reload");
		}
	}

	// Test7. Dynamic content
	public void dynamicControls() {
		WebElement checkbox = driver.findElement(By.xpath("//div//input[@type='checkbox']"));
		String checkBoxTextFirstTime = checkbox.getText();
		System.out.println("Check box test before clicking on remove btn: " + checkBoxTextFirstTime);

		// Click on remove btn
		WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
		removeBtn.click();

		// WebDriver wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

		// message
		WebElement message = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id='message']"))));
		String messageAfterRemoveCheckBox = message.getText();
		System.out.println("message After Remove CheckBox is : " + messageAfterRemoveCheckBox);

		// Enable btn
		WebElement enableBtn = driver.findElement(By.xpath("//button[text()='Enable']"));
		enableBtn.click();

		WebElement message2 = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id='message']"))));
		String messageAfterDisabledTextBox = message2.getText();
		System.out.println("message after disabled text box is : " + messageAfterDisabledTextBox);
		WebElement disabledBtn = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Disable']"))));
		String disableBtnText = disabledBtn.getText();
		System.out.println(disableBtnText);

	}

	// Test8 : Dynamic Loading
	public void dynamicLoading() {
		String actualMsg = "Hello World!";
		WebElement start = driver.findElement(By.xpath("//div[@id='start']//button"));
		start.click();

		// WebDriver wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(6000));
		WebElement finish = driver.findElement(By.xpath("//div[@id='finish']"));
		String finishText = finish.getText();
		System.out.println(finishText);
		Assert.assertEquals(actualMsg, finishText);

	}

	// Test9 :File Download
	public void fileDownload() throws InterruptedException {
		// download dir
		ChromeOptions options = new ChromeOptions();
		options.addArguments("download.default_directory", "Downloads");

		// timestamp
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateFormat.format(new Date());

		// file with timeStamp
		String fileName = "filename_" + timestamp + ".txt";

		WebElement downLaodingFile = driver.findElement(By.xpath("//a[text()='some-file.txt']"));
		downLaodingFile.click();
		// WebDriver wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(6000));
		Thread.sleep(5000);
		// download file path
		// Verify if the file exists in the download folder
		String downloadPath = "C:/Users/bodas/Downloads";
		String filePath = downloadPath + "/" + fileName;

		File file = new File(filePath);
		if (file.exists()) {
			System.out.println("File downloaded successfully.");
		} else {
			System.out.println("File not found in the download folder.");
		}
	}

	// Test 10: File Upload
	public void fileUpload() {
		// Path to the file to be uploaded
		String filePath = "C:/Users/bodas/Downloads/UploadFile/some-file.txt";

		// Locate the file input field
		WebElement fileInput = driver.findElement(By.xpath("//input[@id='file-upload']"));

		// upload using sendkeys
		fileInput.sendKeys("C:/Users/bodas/Downloads/UploadFile/some-file.txt");

		// Upload btn
		WebElement uploadBtn = driver.findElement(By.xpath("//input[@class='button' and @value='Upload']"));
		uploadBtn.click();

		// Verify file uploaded or not
		WebElement uploadeFile = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
		String uplaodedFilename = uploadeFile.getText();
		System.out.println("uplaoded Filename is : " + uplaodedFilename);
		Assert.assertTrue(uploadeFile.isDisplayed());

	}

	// Test12: Floating menu
	private static void scrollDownPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void floatingMenu() {
		// Scroll down the page
		scrollDownPage(driver);

		// Check if the floating menu is available
		WebElement element = driver.findElement(By.xpath("//div[@id='menu']"));
		boolean isFloatingMenuVisible = element.isDisplayed();

		if (isFloatingMenuVisible) {
			System.out.println("Floating menu is still available.");
		} else {
			System.out.println("Floating menu is not available.");
		}
	}

	// Test 13. IFrame
	public void changeFrame() {
		// WebDriver wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		WebElement frame = driver.findElement(By.xpath("//div//div//iframe[@title='Rich Text Area']"));
		wait.until(ExpectedConditions.visibilityOf(frame));
		driver.switchTo().frame(frame);

		WebElement close = wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button//div[@aria-label='Close']"))));
		Actions actions = new Actions(driver);
		actions.moveToElement(close).click();
		// close.click();

		// enter Text
		WebElement enterText = driver.findElement(By.xpath("//body[@class='mce-content-body ']"));
		// Use the Ctrl+A keyboard shortcut to select all text
		actions.sendKeys(Keys.CONTROL + "a");
		// enterText.sendKeys(Keys.CONTROL + "a");
		enterText.clear();

		String actual = "Hello There";
		enterText.sendKeys(actual);

		String expected = enterText.getText();

		Assert.assertEquals(actual, expected);
	}

	// 14. Mouse hover
	public void mouseHover() {
		List<WebElement> allimages = driver.findElements(By.xpath("//div[@class='example']//div[@class='figure'][1]"));
		// instance of Actions class
		Actions actions = new Actions(driver);
		// Iterate over the image elements
		for (WebElement image : allimages) {

			// Perform mouse hover action on the image
			actions.moveToElement(image).perform();
			// Locate the additional info element
			WebElement additionalInfo = image.findElement(By.xpath(".//div//a[contains(@href, '/users')]"));
			// Assert that the additional info is displayed
			boolean isAdditionalInfoDisplayed = additionalInfo.isDisplayed();

			if (isAdditionalInfoDisplayed) {
				System.out.println("Additional info is displayed on mouse hover.");
			} else {
				System.out.println("Additional info is not displayed on mouse hover.");
			}
		}
	}

	// 15. JavaScript Alerts
	public void javaScriptAlerts() {
		// Test Clicks on JS Alert Button.
		WebElement jsAlert = driver.findElement(By.xpath("//div[@class='example']//button[@onclick='jsAlert()']"));
		jsAlert.click();
		String Expectedmsg = "I am a JS Alert";
		String alertmsg = closeAlert();
		// Test asserts alert message.
		Assert.assertEquals(Expectedmsg, alertmsg);

		// Test clicks on JS confirm Button and clicks ok on alert.
		WebElement jsConfirm = driver.findElement(By.xpath("//div[@class='example']//button[@onclick='jsConfirm()']"));
		jsConfirm.click();
		// alertText
		String Expectedmsg2 = "I am a JS Confirm";
		String alertConfirmmsg = closeAlert();
		// Test asserts alert message.
		Assert.assertEquals(Expectedmsg2, alertConfirmmsg);

		// Test clicks on JS Prompt Button and types a message on Prompt.
		WebElement jsPrompt = driver.findElement(By.xpath("//div[@class='example']//button[@onclick='jsPrompt()']"));
		jsPrompt.click();
		String keysTosend = "Testing Java Script Alerts";
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keysTosend);
		alert.accept();
		// Test asserts that the alert message contains the typed message.
		// Capture result: webelement and get text
		WebElement result = driver
				.findElement(By.xpath("//p[contains(text(),'You entered: Testing Java Script Alerts')]"));
		String resulttext = result.getText();
		String resulttext1 = resulttext.substring(resulttext.indexOf(":") + 2);
		System.out.println(resulttext1);
		Assert.assertEquals(keysTosend, resulttext1);

	}

	// 16.JavaScript Error
	public void jsError() {
		// to obtain browser errors
		Set<String> logtyp = driver.manage().logs().getAvailableLogTypes();
		for (String s : logtyp) {
			System.out.println(logtyp);
		}
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<org.openqa.selenium.logging.LogEntry> lg = logEntries.getAll();
		for (org.openqa.selenium.logging.LogEntry logEntry : lg) {
			System.out.println(logEntry);
		}
		// 2.Test asserts that the page contains error: Cannot read property 'xyz' of
		// undefined.
		String ExpectedError = "Cannot read property 'xyz' of undefined.";

	}

	// 17. Open in New Tab
	public void testLisnksOpenInNewWindow() {
		// 1. Test clicks on the Click Here link.
		WebElement clickHereLink = driver.findElement(By.xpath("//a[@href='/windows/new']"));
		clickHereLink.click();

		// Get the window handles of all open windows
		Set<String> windowHandles = driver.getWindowHandles();

		// Switch to the new window
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
		}
		// 2. Test asserts that a new tab is opened with text New Window.
		WebElement newWindowText = driver
				.findElement(By.xpath("//div[@class='example']//h3[contains(text(),'New Window')]"));
		String expectedText = "New Window";
		String actualText = newWindowText.getText();
		System.out.println(actualText);
		Assert.assertEquals(expectedText, actualText);
	}

	// 18. Notification Message
	public void notificationMsg() {
		// 1. Test clicks on the Click Here link a multiple times.
		WebElement clickhere = driver.findElement(By.xpath("//a[@href='/notification_message']"));
		clickhere.click();
		clickhere.click();
		clickhere.click();
		clickhere.click();
		clickhere.click();
		// 2. Test asserts that one of the “Action Successful”, “Action unsuccessful,
		// please try again” and “Action Unsuccessful” messages show on click.
	}
}
