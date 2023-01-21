 package com.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

	private static WebDriver driver;

	@BeforeEach
	public void setUp(){
		driver = Driver.getDriver();
	}
	@AfterEach
	public void tearDown(){
		Driver.quitBrowser();
	}

	@Test
	public void loginTest_positive() {

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		loginPage.visitLoginPage();
		loginPage.login();
		homePage.verifyLogin();

	}
	
	@Test
	public void loginTest_negative() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.visitLoginPage();
		loginPage.verifyInvalidLogin();

	
	}
	
	@Test
	public void contextMenuTest() throws InterruptedException {

		ContextMenu menu = new ContextMenu(driver);
		menu.visitContextMenuPage();
		
		menu.verifyContextMenu();
	
	}
	
	@Test
	public void checkBoxTest() throws InterruptedException {

		CheckBoxPage page = new CheckBoxPage(driver);
		page.visitCheckBoxPage();
		page.verifyCheckBoxOne();
		page.verifyCheckBoxTwo();

	
	}

	@Test
	public void dragAndDropTest() throws InterruptedException {

		DragAndDropPage page = new DragAndDropPage(driver);
		page.visitDragAndDropPage();
		
		page.verifyDragAndDrop();

	}
	
	@Test
	public void dropDownTest() throws InterruptedException {
		

		DropDownPage page = new DropDownPage(driver);
		page.visitDropDownPage();
		
		page.verifyDropDown();
	
	}
	
	@Test
	public void dynamicContentTest() throws InterruptedException {

		DynamicContentPage page = new DynamicContentPage(driver);
		page.visitDynamicContentPage();
		
		page.verifyDynamicContentAfterRefresh();

	}

	@Test
	public void dynamicControlsTest() throws InterruptedException {

		DynamicControls page = new DynamicControls(driver);
		page.visitDynamicControlsPage();
		
		page.verifyDynamicControls();

	}
	
	@Test
	public void dynamicLoadingTest() throws InterruptedException {

		DynamicLoadingPage page = new DynamicLoadingPage(driver);
		page.visitDynamicLoadingPage();
		
		page.verifyDynamicLoading();

	}
	
	@Test
	public void downloadFileTest() throws InterruptedException {

		DownloadPage page = new DownloadPage(driver);
		page.visitDownloadPage();
		
		page.verifyDownloadFile();
	}
	
	@Test
	public void uploadFileTest() throws InterruptedException {

		UploadPage page = new UploadPage(driver);
		page.visitUploadPage();
		
		page.verifyUpload();

	}
	
	@Test
	public void floatingMenuTest() throws InterruptedException {

		FloatingMenu page = new FloatingMenu(driver);
		page.visitFloatingMenuPage();
		page.verifyFloatingMenu();

	}
	
	@Test
	public void iframeTextTest() throws InterruptedException {

		IFramePage page = new IFramePage(driver);
		page.visitIFramePage();
		page.verifyIFrame();

	}
	
	@Test
	public void mouseHoverOverTest() throws InterruptedException {

		MouseHoverPage page = new MouseHoverPage(driver);
		page.visitMouseHoverPage();
		page.verifyElementWithHover();

	}
	
	@Test
	public void jsAlertsTest() throws InterruptedException {

		JsAlertsPage page = new JsAlertsPage(driver);
		page.visitJsAlerstPage();
		page.verifyJsAlerts();

	}
	
	@Test
	public void jsErrorVerifyTest() throws InterruptedException {

		JsErrorPage page = new JsErrorPage(driver);
		page.visitJsErrorPage();
		page.verifyJsError();

	}
	
	@Test
	public void newTabVerifyTest() throws InterruptedException {
		

		OpenNewTabPage page = new OpenNewTabPage(driver);
		page.visitOpenNewTabPage();
		page.verifyNewTabOpen();

	}
	
	@Test
	public void notificationMsgVerifyTest() throws InterruptedException {

		NotificationMessagePage page = new NotificationMessagePage(driver);
		page.visitNotificationMessagePage();
		page.verifyNotificationMessage();

	}
}
