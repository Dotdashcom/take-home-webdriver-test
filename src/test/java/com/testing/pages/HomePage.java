package com.testing.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage {

	WebDriver wd = null;
	Actions actions = null;
	WebDriverWait wait = null;
	Robot rb = null;
	JavascriptExecutor js = null;
	Alert alert = null;

	public HomePage(WebDriver driver) throws AWTException {
		this.wd = driver;
		PageFactory.initElements(wd, this);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		rb = new Robot();
		js = (JavascriptExecutor) driver;

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;

	@FindBy(xpath = "//h4[text()='Welcome to the Secure Area. When you are done click logout below.']")
	WebElement lblSuccess;

	@FindBy(xpath = "//*[@id='checkboxes']/input[1]")
	WebElement chkbox1;

	@FindBy(xpath = "//*[@id='checkboxes']/input[2]")
	WebElement chkbox2;

	@FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
	WebElement lblInvalidLogin;

	@FindBy(xpath = "//div[@id='hot-spot']")
	WebElement tagHotSpot;

	@FindBy(xpath = "//div[@id='column-a']")
	WebElement colA;

	@FindBy(xpath = "//div[@id='column-b']")
	WebElement colB;

	@FindBy(xpath = "//select[@id='dropdown']")
	WebElement dropdown;
	@FindBy(xpath = "//option[@value='1']")
	WebElement opt1;
	@FindBy(xpath = "//option[@value='2']")
	WebElement opt2;

	@FindBy(xpath = "//div[@class='large-10 columns'][1]")
	WebElement dynamic;

	@FindBy(xpath = "//button[text()='Remove']")
	WebElement btnRemove;

	@FindBy(xpath = "//button[text()='Add']")
	WebElement btnAdd;

	@FindBy(xpath = "//p[contains(text(),'gone')]")
	WebElement lblGone;

	@FindBy(xpath = "//input[@id='checkbox']")
	WebElement chkBox;

	@FindBy(xpath = "//button[text()='Enable']")
	WebElement btnEnable;

	@FindBy(xpath = "//button[text()='Disable']")
	WebElement btnDisable;

	@FindBy(xpath = "//input[@type='text']")
	WebElement txtBox;

	@FindBy(xpath = "//h4[text()='Hello World!']")
	WebElement lblHelloWorld;
	@FindBy(xpath = "//button[text()='Start']")
	WebElement btnStart;

	@FindBy(xpath = "//a[text()='some-file.txt']")
	WebElement lnkDownloadFile;

	@FindBy(xpath = "//div[@id='drag-drop-upload']")
	WebElement selectFile;
	@FindBy(xpath = "//input[@value='Upload']")
	WebElement btnUpload;
	@FindBy(xpath = "//div[@id='uploaded-files']")
	WebElement lblUploadedFile;

	@FindBy(xpath = "//div[@id='menu']")
	WebElement topMenu;

	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement frameText;

	@FindBy(xpath = "//h5[text()='name: user1']/ancestor::div/img")
	WebElement img1;
	@FindBy(xpath = "//h5[text()='name: user2']/ancestor::div/img")
	WebElement img2;
	@FindBy(xpath = "//h5[text()='name: user3']/ancestor::div/img")
	WebElement img3;
	@FindBy(xpath = "//h5[text()='name: user1']")
	WebElement imgText1;
	@FindBy(xpath = "//h5[text()='name: user2']")
	WebElement imgText2;
	@FindBy(xpath = "//h5[text()='name: user3']")
	WebElement imgText3;

	@FindBy(xpath = "//button[text()='Click for JS Alert']")
	WebElement alert1;

	@FindBy(xpath = "//button[text()='Click for JS Confirm']")
	WebElement alert2;

	@FindBy(xpath = "//button[text()='Click for JS Prompt']")
	WebElement alert3;

	@FindBy(xpath = "//p[@id='result']")
	WebElement alertMsg;

	@FindBy(xpath = "//a[text()='Click Here']")
	WebElement newWindow;

	@FindBy(xpath = "//h3[text()='New Window']")
	WebElement newWinText;

	@FindBy(xpath = "//a[text()='Click here']")
	WebElement notificationLink;

	public void verifyNotifications() throws InterruptedException {
		Thread.sleep(1000);
		notificationLink.click();
		Thread.sleep(1000);
		String msg = wd.getPageSource();
		if (msg.contains("Action unsuccesful, please try again") || msg.contains("Action successful")
				|| msg.contains("Action Unsuccessful"))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	public void verifyNewWindow() throws InterruptedException {
		Thread.sleep(1000);
		String originalWindow = wd.getWindowHandle();
		newWindow.click();
		Thread.sleep(1000);
		for (String windowHandle : wd.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				wd.switchTo().window(windowHandle);
				break;
			}
		}
		Assert.assertTrue(newWinText.isDisplayed());
	}

	public void verifyJSError() throws InterruptedException {
		Thread.sleep(1000);
		String msg1 = "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.";
		String msg2 = wd.findElement(By.xpath("//p")).getText();
		Assert.assertTrue(msg1.contains(msg2));
		msg1 = "Cannot read properties of undefined (reading 'xyz')";
		try {
			js.executeScript("loadError();");
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(msg1));
		}
	}

	public void verifyJSAlerts() {
		alert1.click();
		alert = wd.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("I am a JS Alert"));
		alert.accept();
		alert2.click();
		alert = wd.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("I am a JS Confirm"));
		alert.accept();
		alert3.click();
		alert = wd.switchTo().alert();
		alert.sendKeys("Hi");
		alert.accept();
		Assert.assertTrue(alertMsg.getText().contains("Hi"));
	}

	public void verifyMouseHover() throws InterruptedException {
		Thread.sleep(1000);
		actions.moveToElement(img1).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(imgText1.isDisplayed());
		Thread.sleep(1000);
		actions.moveToElement(img2).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(imgText2.isDisplayed());
		Thread.sleep(1000);
		actions.moveToElement(img3).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(imgText3.isDisplayed());
		Thread.sleep(1000);
	}

	public void verifyFrames() throws InterruptedException {
		Thread.sleep(2000);
		wd.switchTo().frame("mce_0_ifr");
		String message = "Hello World";
		frameText.sendKeys(message);
		Assert.assertTrue(frameText.getText().contains(message));
	}

	public void verifyFloatingMenu() throws InterruptedException {
		Thread.sleep(3000);

		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		rb.keyRelease(KeyEvent.VK_PAGE_DOWN);

		Assert.assertTrue(topMenu.isDisplayed());
	}

	public void verifyUpload(String path) throws InterruptedException {
		Thread.sleep(3000);

		StringSelection str = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);

		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);
		actions.sendKeys(Keys.ENTER);
		btnUpload.click();
		Thread.sleep(1000);
		Assert.assertTrue(lblUploadedFile.isDisplayed());
	}

	public void verifyFileDownload(String filePath) throws InterruptedException {
		Thread.sleep(2000);
		lnkDownloadFile.click();
		Thread.sleep(2000);
		File file = new File(filePath + File.separator + "some-file.txt");
		Assert.assertTrue(file.exists());

	}

	public void verifyDynamicLoading() {
		btnStart.click();
		wait.until(ExpectedConditions.visibilityOf(lblHelloWorld));
	}

	public void verifyDynamicControls() {
		btnRemove.click();
		wait.until(ExpectedConditions.visibilityOf(lblGone));
		btnAdd.click();
		wait.until(ExpectedConditions.visibilityOf(chkBox));
		Assert.assertTrue(chkBox.isDisplayed());
		btnEnable.click();
		wait.until(ExpectedConditions.elementToBeClickable(txtBox));
		Assert.assertTrue(txtBox.isEnabled());
		btnDisable.click();
		wait.until(ExpectedConditions.attributeToBe(txtBox, "disabled", "true"));
		Assert.assertFalse(txtBox.isEnabled());

	}

	public void login(String usr, String pwd) throws InterruptedException {
		username.sendKeys(usr);
		password.sendKeys(pwd);
		btnLogin.click();
		Thread.sleep(3000);
	}

	public void verifyLoginSuccess() {
		Assert.assertTrue(lblSuccess.isDisplayed());
	}

	public void verifyInvalidLogin() {
		Assert.assertTrue(lblInvalidLogin.isDisplayed());
	}

	public void verifyCheckbox() {
		chkbox1.click();
		Assert.assertTrue(chkbox1.isSelected());
		chkbox2.click();
		Assert.assertFalse(chkbox2.isSelected());
	}

	public void verifyContextmenu() throws InterruptedException {
		Thread.sleep(1000);
		actions.contextClick(tagHotSpot).perform();
		Thread.sleep(1000);
		Assert.assertEquals("You selected a context menu", wd.switchTo().alert().getText());
		wd.switchTo().alert().dismiss();
	}

	public void verifyDragDrop() throws InterruptedException {
		Thread.sleep(2000);
		actions.dragAndDrop(colB, colA).perform();
		Thread.sleep(6000);
		Assert.assertTrue(colB.getText().contains("A"));
	}

	public void verifyDropAndDown() {
		Select opt = new Select(dropdown);
		opt.selectByIndex(1);
		Assert.assertEquals("Option 1", opt1.getText());
		opt.selectByIndex(2);
		Assert.assertEquals("Option 2", opt2.getText());
	}

	public void verifyDynamicText() throws InterruptedException {
		String str = dynamic.getText();
		Thread.sleep(1000);
		wd.navigate().refresh();
		Thread.sleep(1000);
		Assert.assertNotSame(str, dynamic.getText());
	}

}
