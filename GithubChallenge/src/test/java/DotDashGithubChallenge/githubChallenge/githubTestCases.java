package DotDashGithubChallenge.githubChallenge;



import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jsoup.select.Selector;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class githubTestCases {
	
	@Test 
	public void loginSuccess() {
		
	
		WebDriver driver = Driver.getDriver();
		LoginPage loginPage = new LoginPage(driver);
		driver.get("http://localhost:7080/login ");
		
		
		loginPage.sendUserCredentials("tomsmith", "SuperSecretPassword!");
		loginPage.loginSuccess();
		
		Driver.quitBrowser();
		
	}
	
	@Test
	public void loginFailure() {
		
		WebDriver driver = Driver.getDriver();
		LoginPage loginPage = new LoginPage(driver);
		driver.get("http://localhost:7080/login ");
		
		
		loginPage.sendUserCredentials("tomsmit", "SuperSecretPasswor");
		loginPage.loginFailure();
		
		Driver.quitBrowser();
		
	}
	 
	@Test
	public void checkBoxes() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
		driver.get("http://localhost:7080/checkboxes ");
		
		checkBoxPage.verifyCheckboxes();
		
		Driver.quitBrowser();
	}
	
	
	@Test
	public void contextMenu() {
		
		WebDriver driver = Driver.getDriver();
		ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
		driver.get("http://localhost:7080/context_menu");
		
		contextMenuPage.rightClickContextBox();
		
		Driver.quitBrowser();
		
	}
	
	
	@Test
	public void dragandDrop() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		DragandDropPage dragandDropPage = new DragandDropPage(driver);		
		driver.get("http://localhost:7080/drag_and_drop");
		
	//	dragandDropPage.verifyDragAndDrop();
		
		
		
		Driver.quitBrowser();
		
	}
	
	@Test
	public void dropDownMenu() {
		
		WebDriver driver = Driver.getDriver();
		DropDownMenuPage dropDownMenuPage = new DropDownMenuPage(driver);
		driver.get("http://localhost:7080/dropdown");
	
		dropDownMenuPage.verifySelectedOptions();
		
		Driver.quitBrowser();
		
	
	}
	
	
	@Test
	public void dynamicContent() {
		
		WebDriver driver = Driver.getDriver();
		DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
		driver.get("http://localhost:7080/dynamic_content");
		
		dynamicContentPage.verifyDynamicContent();
		
		Driver.quitBrowser();
		
	
		
	}
	
	@Test
	public void dynamicControls() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
		driver.get("http://localhost:7080/dynamic_controls ");
		
		dynamicControlsPage.verifyRemoveBtn();
		dynamicControlsPage.addAndVerifyMessageIsVisible();
		dynamicControlsPage.enableTextboxAndVerifyMessageIsVisible();
		dynamicControlsPage.disableTextboxAndVerifyMessageIsNotThere();
		
		Driver.quitBrowser();
		
	
		
	}
	
	@Test
	public void dynamicLoading() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
		driver.get("http://localhost:7080/dynamic_loading/2");
		
		dynamicLoadingPage.verifyDynamicLoad();
		
		Driver.quitBrowser();
	}
	
	
	@Test
	public void downloadVerification(){
		
		WebDriver driver = Driver.getDriver();
		DownloadPage downloadPage = new DownloadPage(driver);
		driver.get("http://localhost:7080/download");
		
		downloadPage.verifyDownload();
		
		
		Driver.quitBrowser();
		
		
	}
	
	
	@Test
	public void uploadVerification() throws InterruptedException {
		
		
		WebDriver driver = Driver.getDriver();
		UploadPage uploadPage = new UploadPage(driver);
		driver.get("http://localhost:7080/upload");
		
		String fileName = "some-file.txt";	
		String path = System.getProperty("user.dir");
	    String separator = System.getProperty("file.separator");
	    String filePath = path + separator + fileName;
	    
	    uploadPage.uploadFile(filePath);
        assertEquals(true,uploadPage.verifyUploadSuccessfully());
		
		
		
		
		Driver.quitBrowser(); 
		
	
		
	}
	
	@Test
	public void floatingMenu() {
		
		WebDriver driver = Driver.getDriver();
		FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
		
		floatingMenuPage.verifyFloatingMenu();
		
		Driver.quitBrowser();
		
	
		
	}
	
	@Test
	public void iframe() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		IframePage iframePage = new IframePage(driver);
		driver.get("http://localhost:7080/iframe");
		
		iframePage.switchIframe();
		
		
		Driver.quitBrowser();
		
	
		
	}

	
	@Test
	public void mouseOver() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		MousOverPage mousOverPage = new MousOverPage(driver);
		driver.get("http://localhost:7080/hovers");
		
		mousOverPage.verifyUsers();
	
		Driver.quitBrowser();
	}
	
	@Test
	public void jsAlerts() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		JsAlertsPage jsAlertsPage = new JsAlertsPage(driver);
		driver.get("http://localhost:7080/javascript_alerts");
		
		jsAlertsPage.verifyAlerts();
		
		Driver.quitBrowser();
	}
	
	@Test
	public void jsError() {
		WebDriver driver = Driver.getDriver();
		JsErrorPage jsErrorPage = new JsErrorPage(driver);
		driver.get("http://localhost:7080/javascript_error");
		
		jsErrorPage.verifyJsError();
		
		Driver.quitBrowser();
	}
	
	@Test
	public void switchWindow() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		NewWindowPage newWindowPage = new NewWindowPage(driver);
		driver.get("http://localhost:7080/windows");
		
		newWindowPage.verifyNewWindowOpen();
		
		
		Driver.quitBrowser();
	}
	
	@Test
	public void notificationMessage() {
	
		WebDriver driver = Driver.getDriver();
		driver.get("http://localhost:7080/notification_message_rendered");
		NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
		
		List<String> possibleMessages = Arrays.asList("Action unsuccesful, please try again",
	            "Action successful",
	            "Action unsuccesful, please try again");
		
		notificationMessagePage.verifyNotificationMessage(possibleMessages);
		 
		Driver.quitBrowser(); 
		 
	}
}

	