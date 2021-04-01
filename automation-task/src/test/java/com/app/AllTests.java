package com.app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import com.app.pages.CheckBoxPage;
import com.app.pages.ContextMenu;
import com.app.pages.DownloadPage;
import com.app.pages.DragAndDropPage;
import com.app.pages.DropDownPage;
import com.app.pages.DynamicContentPage;
import com.app.pages.DynamicControls;
import com.app.pages.DynamicLoadingPage;
import com.app.pages.FloatingMenu;
import com.app.pages.HomePage;
import com.app.pages.IFramePage;
import com.app.pages.JsAlertsPage;
import com.app.pages.JsErrorPage;
import com.app.pages.LoginPage;
import com.app.pages.MouseHoverPage;
import com.app.pages.NotificationMessagePage;
import com.app.pages.OpenNewTabPage;
import com.app.pages.UploadPage;
import com.app.util.Driver;

public class AllTests {


	@Test
	public void loginTest_positive() {
		
		WebDriver driver = Driver.getDriver();
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		loginPage.visitLoginPage();
		loginPage.login();
		homePage.verifyLogin();
	
		Driver.quitBrowser();
	}
	
	@Test
	public void loginTest_negative() {
		
		WebDriver driver = Driver.getDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.visitLoginPage();
		loginPage.verifyInvalidLogin();
		
		Driver.quitBrowser();
	
	}
	
	@Test
	public void contextMenuTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		ContextMenu menu = new ContextMenu(driver);
		menu.visitContextMenuPage();
		
		menu.verifyContextMenu();
		
		
		Driver.quitBrowser();
	
	}
	
	@Test
	public void checkBoxTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		CheckBoxPage page = new CheckBoxPage(driver);
		page.visitCheckBoxPage();
		page.verifyCheckBoxOne();
		page.verifyCheckBoxTwo();
		
		Driver.quitBrowser();
	
	}

	@Test
	public void dragAndDropTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		DragAndDropPage page = new DragAndDropPage(driver);
		page.visitDragAndDropPage();
		
		page.verifyDragAndDrop();
	
		Driver.quitBrowser();
	}
	
	@Test
	public void dropDownTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		DropDownPage page = new DropDownPage(driver);
		page.visitDropDownPage();
		
		page.verifyDropDown();
		
		
		Driver.quitBrowser();
	
	}
	
	@Test
	public void dynamicContentTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		DynamicContentPage page = new DynamicContentPage(driver);
		page.visitDynamicContentPage();
		
		page.verifyDynamicContentAfterRefresh();
		
		
		Driver.quitBrowser();
	
	}

	@Test
	public void dynamicControlsTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		DynamicControls page = new DynamicControls(driver);
		page.visitDynamicControlsPage();
		
		page.verifyDynamicControls();
		
		
		Driver.quitBrowser();
	
	}
	
	@Test
	public void dynamicLoadingTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		DynamicLoadingPage page = new DynamicLoadingPage(driver);
		page.visitDynamicLoadingPage();
		
		page.verifyDynamicLoading();
		
		
		Driver.quitBrowser();
	
	}
	
	@Test
	public void downloadFileTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		DownloadPage page = new DownloadPage(driver);
		page.visitDownloadPage();
		
		page.verifyDownloadFile();
		
		
		Driver.quitBrowser();
	
	}
	
	@Test
	public void uploadFileTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		UploadPage page = new UploadPage(driver);
		page.visitUploadPage();
		
		page.verifyUpload();
		
		
		Driver.quitBrowser();
	
	}
	
	@Test
	public void floatingMenuTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		FloatingMenu page = new FloatingMenu(driver);
		page.visitFloatingMenuPage();
		page.verifyFloatingMenu();
		
		Driver.quitBrowser();

	}
	
	@Test
	public void iframeTextTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		IFramePage page = new IFramePage(driver);
		page.visitIFramePage();
		page.verifyIFrame();
		
		Driver.quitBrowser();

	}
	
	@Test
	public void mouseHoverOverTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		MouseHoverPage page = new MouseHoverPage(driver);
		page.visitMouseHoverPage();
		page.verifyElementWithHover();
		Driver.quitBrowser();
	}
	
	@Test
	public void jsAlertsTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		JsAlertsPage page = new JsAlertsPage(driver);
		page.visitJsAlerstPage();
		page.verifyJsAlerts();
		Driver.quitBrowser();
	}
	
	@Test
	public void jsErrorVerifyTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		JsErrorPage page = new JsErrorPage(driver);
		page.visitJsErrorPage();
		page.verifyJsError();
		Driver.quitBrowser();
	}
	
	@Test
	public void newTabVerifyTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		OpenNewTabPage page = new OpenNewTabPage(driver);
		page.visitOpenNewTabPage();
		page.verifyNewTabOpen();
		Driver.quitBrowser();
	}
	
	@Test
	public void notificationMsgVerifyTest() throws InterruptedException {
		
		WebDriver driver = Driver.getDriver();
		NotificationMessagePage page = new NotificationMessagePage(driver);
		page.visitNotificationMessagePage();
		page.verifyNotificationMessage();
		Driver.quitBrowser();
	}
}
