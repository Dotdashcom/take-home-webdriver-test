package com.test.qa.pages;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement checkBox1;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement checkBox2;

	@FindBy(xpath = "//div[@id='hot-spot']")
	WebElement contextMenu;

	@FindBy(xpath = "//div[@id='column-a']")
	WebElement elementA;

	@FindBy(xpath = "//div[@id='column-b']")
	WebElement elementB;

	@FindBy(xpath = "//div[@id='column-a']/header")
	WebElement elementAHeader;

	@FindBy(xpath = "//div[@id='column-b']/header")
	WebElement elementBHeader;

	@FindBy(xpath = "//select[@id='dropdown']")
	WebElement dropDown;

	@FindBy(xpath = "//a[text()='click here']")
	WebElement dynamicContentClick;

	@FindBy(xpath = "(//div[@class='large-10 columns'])[3]")
	WebElement dynamicContent;

	@FindBy(xpath = "//div[@id='start']/button")
	WebElement dynamicLoadingClick;

	@FindBy(xpath = "//h4[text()='Hello World!']")
	WebElement dynamicLoadingText;

	@FindBy(xpath = "//a[text()='some-file.txt']")
	WebElement downloadFile;

	@FindBy(xpath = "(//input[@type='file'])[1]")
	WebElement chooseFile;

	@FindBy(id = "tinymce")
	WebElement frameText;

	@FindBy(xpath = "//h3[text()='Floating Menu']")
	WebElement floatingMenuText;

	@FindBy(xpath = "//button[text()='Click for JS Alert']")
	WebElement jsAlertClick;

	@FindBy(xpath = "//button[@onclick='jsConfirm()']")
	WebElement jsConfirmClick;

	@FindBy(xpath = "//button[@onclick='jsPrompt()']")
	WebElement jsPromptClick;

	@FindBy(xpath = "//p[@id='result']")
	WebElement alertText;

	@FindBy(xpath = "//a[text()='Click Here']")
	WebElement clickHere;

	@FindBy(xpath = "//h3[text()='New Window']")
	WebElement text;

	@FindBy(xpath = "//a[text()='Click here']")
	WebElement notificationMsg;

	@FindBy(xpath = "//div[@id='flash']")
	WebElement actionSuccess;
	
	@FindBy(xpath = "//button[text()='Remove']")
	WebElement removeBtn;
	
	@FindBy(xpath = "//button[text()='Enable']")
	WebElement enableBtn;
	
	@FindBy(xpath = "//button[text()='Add']")
	WebElement addBtn;
	
	@FindBy(xpath = "//button[text()='Disable']")
	WebElement disableBtn;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement box;
	
	@FindBy(xpath = "//p[@id='message']")
	WebElement message;
	
	@FindBy(xpath = "//input[@id='file-submit']")
	WebElement upload;
	
	@FindBy(xpath = "//h3[text()='File Uploaded!']")
	WebElement uploadSuccessMsg;
	
	
	
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String un, String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

	}

	public boolean verifyCheckboxes() {
		if ((!checkBox1.isSelected()) && (checkBox2.isSelected())) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyCheckboxesWithInput() {
		checkBox1.click();
		checkBox2.click();
		if ((!checkBox1.isSelected()) && (checkBox2.isSelected())) {
			return true;
		} else {
			return false;
		}

	}

	public String alertValidation() throws InterruptedException {

		action = new Actions(driver);
		action.contextClick(contextMenu).build().perform();
//		String alertText = driver.switchTo().alert().getText();

		return driver.switchTo().alert().getText();

	}

	public String dragAndDropValidation() throws InterruptedException {
		action = new Actions(driver);
		action.dragAndDrop(elementA, elementB).build().perform();
		Thread.sleep(2000);

		return elementBHeader.getText();

	}

	public void dropDownValidation() throws InterruptedException {

		select = new Select(dropDown);
		select.selectByValue("1");
		WebElement o1 = select.getFirstSelectedOption();
		text1 = o1.getText();
		Thread.sleep(2000);
		select.selectByValue("2");
		WebElement o2 = select.getFirstSelectedOption();
		text2 = o2.getText();
	}

	public void dynamicContentValidation() {

		dynamicContentText1 = dynamicContent.getText();
		dynamicContentClick.click();
		dynamicContentText2 = dynamicContent.getText();

	}

	public void dynamicLoadingClickValidation() {

		dynamicLoadingClick.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		dynamicLoadingText1 = dynamicLoadingText.getText();
		Assert.assertTrue(dynamicLoadingText.isDisplayed());

	}

	public void fileDownloadValidation() throws InterruptedException {
		downloadFile.click();
		Thread.sleep(2000);
		
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File("C:\\Users\\14169\\Downloads");
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals("some-file.txt")) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}

	public void frameValidation() throws InterruptedException {
		driver.findElement(By.xpath("//div[@role='alert']/button")).click();
//		Thread.sleep(2000);
		driver.switchTo().frame("mce_0_ifr");
		frameText.clear();
		frameText.sendKeys("Vinit Patel");

	}

	public void floatingMenuValidation() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,25)");
		text3 = floatingMenuText.getText();
		flag = floatingMenuText.isDisplayed();
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0,1000)");

	}

	public void mouseHoverValidation() throws InterruptedException {
		action = new Actions(driver);
		List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']"));
		int size = images.size();
		System.out.println(size);
		for (int i = 1; i <= size; i++) {
			
			action.moveToElement(driver.findElement(By.xpath("(//div[@class='figure'])["+i+"]"))).build().perform();
			Thread.sleep(1000);
			String usertext = driver.findElement(By.xpath("//h5[text()='name: user"+i+"']")).getText();
			System.out.println(usertext);
//			String text = driver.findElement(By.xpath("(//h5[text()='name: user1'])")).getText();
			Assert.assertTrue(usertext.contains("name: user"));
//			Thread.sleep(1000);
			
//			WebElement info = driver.findElement(By.xpath("//div[@class='figure']//h5["+i+"]"));
//			String text1 = info.getText();
//			Assert.assertTrue(info.isDisplayed());

		}

	}

	public void javaScriptAlertsValidation() throws InterruptedException {

		jsAlertClick.click();
		driver.switchTo().alert().accept();
		jsConfirmClick.click();
		driver.switchTo().alert().accept();
		jsPromptClick.click();
		driver.switchTo().alert().sendKeys("Vinit Patel");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String text1 = alertText.getText();
		Assert.assertTrue(text1.contains("Vinit Patel"));

	}

	public void childWindowValidation() {
		String gettext = null;
		clickHere.click();
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String child_window=it.next();
			driver.switchTo().window(child_window);
		}
		gettext = text.getText();
		Assert.assertEquals(gettext,"New Window");
		

	}

	public void notificationMessageValidation() {
		notificationMsg.click();
		String text = actionSuccess.getText();
		if (text.contains("Action successful")) {
			Assert.assertTrue(text.contains("Action successful"));
		} else if (text.contains("Action unsuccesful, please try again")) {
			Assert.assertTrue(text.contains("Action unsuccesful, please try again"));

		} else {
			Assert.assertTrue(text.contains("Action Unsuccessful"));

		}
	}
	
	public void dynamicControlsValidation() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		removeBtn.click();
//		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//input[@type='checkbox']"), " A checkbox"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		Assert.assertTrue(checkBox.isEnabled());
		addBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		Assert.assertTrue(checkBox.isDisplayed());
		enableBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
		Assert.assertTrue(box.isEnabled());
		disableBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[@id='message']"), "It's disabled!"));
		Assert.assertFalse(box.isEnabled());
		
		
	}
	
	public void fileUploadValidation() throws InterruptedException {
		File file = new File("C:\\Users\\14169\\Desktop\\QA\\Selenium_Workspace\\TestProject\\download.png");
		chooseFile.sendKeys(file.getAbsolutePath());
		Thread.sleep(2000);
		upload.click();
		Thread.sleep(2000);
		Assert.assertEquals(uploadSuccessMsg.getText(), "File Uploaded!");
		
		
	}
	
}
