package tests;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.*;

public class AllTests {
	WebDriver driver;
	@BeforeClass
	public void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	public void setup() {
		//Running Chrome in Headless mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		
		//Running Chrome in regular mode
		// driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void teardown() {
		if(driver != null)
			driver.quit();
	}
	
	@Test
	public void test_login_success() {
		driver.get("http://localhost:7080/login");
		
		LoginPage loginPage = new LoginPage(driver);
		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		loginPage.Login(username, password);
		
		SecurePage securePage = new SecurePage(driver);
		Assert.assertTrue(securePage.isSecuredPageDisplayed(), "Login Failed!");
	}
	
	@Test
	public void test_login_failed_nonexisting_username() {
		driver.get("http://localhost:7080/login");
		
		LoginPage loginPage = new LoginPage(driver);
		String username = "abc";
		String password = "abc";
		loginPage.Login(username, password);
		
		String failureMessage = loginPage.getFailureMessage();
		String expectedMessage = "Your username is invalid!";
		Assert.assertTrue(failureMessage.trim().contains(expectedMessage));
	}
	
	@Test
	public void test_login_failed_incorrect_password() {
		driver.get("http://localhost:7080/login");
		
		LoginPage loginPage = new LoginPage(driver);
		String username = "tomsmith";
		String password = "abc";
		loginPage.Login(username, password);
		
		String failureMessage = loginPage.getFailureMessage();
		String expectedMessage = "Your password is invalid!";
		Assert.assertTrue(failureMessage.trim().contains(expectedMessage));
	}
	
	@Test
	public void test_checkboxes() {
		driver.get("http://localhost:7080/checkboxes");
		
		CheckboxPage checkboxPage = new CheckboxPage(driver);
		int numCheckboxes = checkboxPage.getNumberOfCheckboxes();
		for(int i = 0; i < numCheckboxes; i++) {
			if(checkboxPage.isCheckboxChecked(i)) {
				checkboxPage.clickCheckbox(i);
				Assert.assertFalse(checkboxPage.isCheckboxChecked(i), "Failed to uncheck checkbox 1");
			} else {
				checkboxPage.clickCheckbox(i);
				Assert.assertTrue(checkboxPage.isCheckboxChecked(i), "Failed to check checkbox 1");
			}
		}
	}
	
	@Test
	public void test_context_menu() {
		driver.get("http://localhost:7080/context_menu");
		
		ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
		contextMenuPage.rightClickMenu();
		String alertText = contextMenuPage.getAlertTextAndCloseAlert();
		Assert.assertEquals(alertText.trim(), "You selected a context menu");
	}
	
	@Test
	public void test_drag_and_drop() {
		driver.get("http://localhost:7080/drag_and_drop");
		
		DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
		dragAndDropPage.dragAndDropSwapColumn();
		String rightColumnText = dragAndDropPage.getCurrentRightColumnHeaderText();
		String leftColumnText = dragAndDropPage.getCurrentLeftColumnHeaderText();
		Assert.assertEquals(leftColumnText, "B");
		Assert.assertEquals(rightColumnText, "A");
	}
	
	@Test
	public void test_dropdown() {
		driver.get("http://localhost:7080/dropdown");
		
		DropdownPage dropdownPage = new DropdownPage(driver);
		Assert.assertEquals(dropdownPage.selectDropdownOption("Option 1"), "Option 1");
		Assert.assertEquals(dropdownPage.selectDropdownOption("Option 2"), "Option 2");
	}

	@Test
	public void test_dynamic_content() {
		driver.get("http://localhost:7080/dynamic_content");
		
		DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
		List<String> pastContentsList = dynamicContentPage.getCurrentContentsList();
		driver.navigate().refresh();
		List<String> currentContentsList = dynamicContentPage.getCurrentContentsList();
		Assert.assertFalse(currentContentsList.removeAll(pastContentsList), "Contents were not changed after page refresh");
		
		pastContentsList = new ArrayList<String>(currentContentsList);
		driver.navigate().refresh();
		currentContentsList = dynamicContentPage.getCurrentContentsList();
		Assert.assertFalse(currentContentsList.removeAll(pastContentsList), "Contents were not changed after page refresh");
		
		pastContentsList = new ArrayList<String>(currentContentsList);
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		currentContentsList = dynamicContentPage.getCurrentContentsList();
		Assert.assertFalse(currentContentsList.removeAll(pastContentsList), "Contents were not changed after page refresh");
	}
	
	@Test
	public void test_dynamic_controls_add_remove_checkbox() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_controls");
		
		DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
		
		String buttonText = dynamicControlsPage.getAddRemoveBtnTextAfterClick();
		Assert.assertFalse(dynamicControlsPage.isCheckboxPresent(), "Checkbox still exists after Remove button clicked");
		Assert.assertEquals(buttonText.trim(), "Add");
		
		buttonText = dynamicControlsPage.getAddRemoveBtnTextAfterClick();
		Assert.assertTrue(dynamicControlsPage.isCheckboxPresent(), "Checkbox does not exist after Add button clicked");
		Assert.assertEquals(buttonText.trim(), "Remove");
	}
	
	@Test
	public void test_dynamic_controls_enable_disable_textbox() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_controls");
		
		DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
		
		String buttonText = dynamicControlsPage.getEnableDisableBtnTextAfterClick();
		Assert.assertTrue(dynamicControlsPage.isTextInputEnabled());
		Assert.assertEquals(buttonText.trim(), "Disable");
		
		buttonText = dynamicControlsPage.getEnableDisableBtnTextAfterClick();
		Assert.assertFalse(dynamicControlsPage.isTextInputEnabled());
		Assert.assertEquals(buttonText.trim(), "Enable");
	}
	
	@Test
	public void test_dynamic_loading() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_loading/2");
		
		DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
		
		String displayedText = dynamicLoadingPage.getDisplayTextAfterStartButtonClick();
		Assert.assertEquals(displayedText.trim(), "Hello World!");
	}
	
	@Test
	public void test_file_download() throws InterruptedException {
		driver.get("http://localhost:7080/download");
		
		FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
		String filePath = System.getProperty("user.home")+"\\Downloads\\";
		Assert.assertTrue(fileDownloadPage.isFileDownloaded(filePath), "File is not downloaded as expected");
	}
	
	@Test(dependsOnMethods= {"test_file_download"})
	public void test_file_upload() {
		driver.get("http://localhost:7080/upload");
		
		FileUploadPage fileUploadPage = new FileUploadPage(driver);
		String fileName = "some-file.txt";
		String fileDir = System.getProperty("user.home")+"\\Downloads\\";
		Assert.assertEquals(fileUploadPage.uploadFile(fileDir+fileName).trim(), fileName);
	}
	
	@Test
	public void test_floating_menu() {
		driver.get("http://localhost:7080/floating_menu");
		
		FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
		
		Assert.assertTrue(floatingMenuPage.isMenuDisplayed(), "Floating Menu is not displayed");
		floatingMenuPage.scrollPageByPixel(0, 500);
		Assert.assertTrue(floatingMenuPage.isMenuDisplayed(), "Floating Menu is not displayed after scroll down 500 px");
		floatingMenuPage.scrollPageByPixel(0, 1000);
		Assert.assertTrue(floatingMenuPage.isMenuDisplayed(), "Floating Menu is not displayed after scroll down 1000 px");
		floatingMenuPage.scrollPageByPixel(0, 2000);
		Assert.assertTrue(floatingMenuPage.isMenuDisplayed(), "Floating Menu is not displayed after scroll down 2000 px");
	}
	
	@Test
	public void test_iframe() {
		driver.get("http://localhost:7080/iframe");
		
		IFramePage iFramePage = new IFramePage(driver);
		String text = "Test iFrame enter text!";
		
		Assert.assertEquals(iFramePage.switchIFrameAndEnterText(text), text);
	}
	
	@Test
	public void test_mouse_hover() throws InterruptedException {
		driver.get("http://localhost:7080/hovers");
		
		MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);
		int numOfImages = mouseHoverPage.getNumberOfImages();
		
		for(int i = 0; i < numOfImages; i++) {
			mouseHoverPage.moveMouseHoverOnImage(i);
			Assert.assertTrue(mouseHoverPage.isAdditionalInformationDisplayed(i), String.format("%dth image does not display additional information when mouse hover", i));
		}
	}
	
	@Test
	public void test_javascript_alerts() {
		driver.get("http://localhost:7080/javascript_alerts");
		
		JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
		Assert.assertEquals(javaScriptAlertsPage.jsAlertClick().trim(), "I am a JS Alert");
		Assert.assertEquals(javaScriptAlertsPage.jsConfirmClick().trim(), "I am a JS Confirm");
		Assert.assertTrue(javaScriptAlertsPage.jsPromptClick("Test JavaScript Prompt Click Text").trim().contains("Test JavaScript Prompt Click Text"));
	}
	
	@Test
	public void test_javascript_error() {
		driver.get("http://localhost:7080/javascript_error");
		
		JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver);
		Assert.assertTrue(javaScriptErrorPage.containsJsError("Cannot read property 'xyz' of undefined"), "The page doesn't contain the expected error");
	}
	
	@Test
	public void test_open_new_tab() throws InterruptedException {
		driver.get("http://localhost:7080/windows");
		
		OpenNewTabPage openNewTabPage = new OpenNewTabPage(driver);
		Assert.assertEquals(openNewTabPage.getTextFromNewTab().trim(), "New Window");
	}
	
	@Test
	public void test_notification_message() throws InterruptedException {
		driver.get("http://localhost:7080/notification_message_rendered");
		List<String> expectedMessagesList = new ArrayList<String>();
		expectedMessagesList.add("Action successful");
		expectedMessagesList.add("Action unsuccesful, please try again");
		expectedMessagesList.add("Action unsuccessful");
		
		NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
		String notificationMessage = notificationMessagePage.getNotificationMessage().trim().toLowerCase();
		boolean expected = false;
		for(String expectedMessage : expectedMessagesList) {
			if(notificationMessage.contains(expectedMessage.toLowerCase())) {
				expected = true;
				break;
			}
		}
		Assert.assertTrue(expected, String.format("%s is not in the expected message list", notificationMessage));
	}
}
