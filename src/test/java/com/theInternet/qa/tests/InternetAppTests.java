package com.theInternet.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.theInternet.qa.pages.CheckBoxesPage;
import com.theInternet.qa.pages.ContextMenuPage;
import com.theInternet.qa.pages.DragAndDropPage;
import com.theInternet.qa.pages.DropDownpage;
import com.theInternet.qa.pages.DynamicContentPage;
import com.theInternet.qa.pages.DynamicControlsPage;
import com.theInternet.qa.pages.DynamicLoadingPage;
import com.theInternet.qa.pages.FileDownloadPage;
import com.theInternet.qa.pages.FileUploadPage;
import com.theInternet.qa.pages.FloatingMenuPage;
import com.theInternet.qa.pages.IFramePage;
import com.theInternet.qa.pages.JSAlertsPage;
import com.theInternet.qa.pages.JSErrorPage;
import com.theInternet.qa.pages.LoginPage;
import com.theInternet.qa.pages.MouseHoversPage;
import com.theInternet.qa.pages.NewTabPage;
import com.theInternet.qa.pages.NotificationMessagePage;
import com.theinernet.qa.base.base;

public class InternetAppTests extends base {

	@BeforeMethod
	public void setup() {
		driver = IntializeBrowser("chrome");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void Test_Login_ValidCredentials() {
		Open_URL("login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Verify_Login_Success();
	}

	@Test(priority = 2)
	public void Test_Login_InValidCredentials() {
		Open_URL("login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Verify_Login_Failure();

	}

	@Test(priority = 3)
	public void Test_CheckBoxes() throws InterruptedException {
		Open_URL("checkboxes");
		CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
		checkBoxesPage.verifyCheckboxesSelection();

	}

	@Test(priority = 4)
	public void Test_ContextMenu() {
		Open_URL("context_menu");
		ContextMenuPage contextMenupage = new ContextMenuPage(driver);
		contextMenupage.VerifyContextMenuAlert();
	}

	@Test(priority = 5)
	public void Test_dragAndDrop() {
		Open_URL("drag_and_drop");
		DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
		dragAndDropPage.VerifyDragAndDrop();
	}

	@Test(priority = 6)
	public void Test_dropdown() {
		Open_URL("dropdown");
		DropDownpage dropDownPage = new DropDownpage(driver);
		dropDownPage.VerifyDropDown();

	}

	@Test(priority = 7)
	public void Test_DynamicContent() {
		Open_URL("dynamic_content");
		DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
		dynamicContentPage.verifyDynamicContentOnRefresh();
	}

	@Test(priority = 8)
	public void Test_DynamicControls() {
		Open_URL("dynamic_controls");
		DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
		dynamicControlsPage.VerifyDynamicControls();
	}

	@Test(priority = 9)
	public void Test_Dynamic_Loading() {
		Open_URL("dynamic_loading/2");
		DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
		dynamicLoadingPage.VerifyDynamic_Loading_WithExplicitWait();
	}

	@Test(priority = 10)
	public void Test_File_Download() {
		Open_URL("download");
		FileDownloadPage downLoadPage = new FileDownloadPage(driver);
		downLoadPage.VerifyFile_Download();
	}

	@Test(priority = 11)
	public void Test_File_Upload() {
		Open_URL("upload");
		FileUploadPage upLoadPage = new FileUploadPage(driver);
		upLoadPage.VerifyFileUpLoad();
	}

	@Test(priority = 12)
	public void Test_Floating_Menu() {
		Open_URL("floating_menu");
		FloatingMenuPage menuPage = new FloatingMenuPage(driver);
		menuPage.VerifyFloatingMenudisplay();
	}

	@Test(priority = 13)
	public void Test_IFrame() {
		Open_URL("iframe");
		IFramePage iframePage = new IFramePage(driver);
		iframePage.VerifyIframeText();
	}

	@Test(priority = 14)
	public void TestMouseHovers() {
		Open_URL("hovers");
		MouseHoversPage mouseHoversPage = new MouseHoversPage(driver);
		mouseHoversPage.VerifyMousehoverText();
	}

	@Test(priority = 15)
	public void TestJSAlertMsg() {
		Open_URL("javascript_alerts");
		JSAlertsPage JSalert = new JSAlertsPage(driver);
		JSalert.VerifyJSAlertMessage();
	}

	@Test(priority = 16)
	public void TestJSError() {
		Open_URL("javascript_error");
		JSErrorPage JSerrorPage = new JSErrorPage(driver);
		JSerrorPage.VerifyJSErrormessage();
	}

	@Test(priority = 17)
	public void TestNewTab() {
		Open_URL("windows");
		NewTabPage newTabPage = new NewTabPage(driver);
		newTabPage.verifyNewTabDisplay();
	}

	@Test(priority = 18)
	public void TestNotificationMessage() {
		Open_URL("notification_message_rendered");
		NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
		notificationMessagePage.VerifyNotificationMessagePage();
	}
}
