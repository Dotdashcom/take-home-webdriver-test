package tests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.CheckBox;
import pageObjects.ContextMenuPage;
import pageObjects.DragAndDropPage;
import pageObjects.DropDownPage;
import pageObjects.DynamicContentPage;
import pageObjects.DynamicControlsPage;
import pageObjects.DynamicLoadingPage;
import pageObjects.FileDownloadPage;
import pageObjects.FileUploadPage;
import pageObjects.FloatingMenuPage;
import pageObjects.HomePage;
import pageObjects.IframePage;
import pageObjects.JavascriptAlertsPage;
import pageObjects.JavascriptErrorPage;
import pageObjects.LoginPage;
import pageObjects.MouseHoverPage;
import pageObjects.NewTabPage;
import pageObjects.NotificationPage;
import reportingUtils.TestListener;
@Listeners(TestListener.class)
public class WebDriverTesting extends BasicTestConfiguration{

	@Test(priority = 1, description = "Checking login with correct credentails", testName= "Validate Login")
	public void testLogin()
	{
		Reporter.log("Test:1 Testing login with correct credentials started"); 
		LoginPage objLogin = new LoginPage(driver);
		objLogin.navigateToUrl(p.getProperty("loginURL"));
		objLogin.loginToInternet(p.getProperty("username"), p.getProperty("password"));
		HomePage objHomePage = new HomePage(driver);
		Assert.assertTrue(objHomePage.getHomePageURL().contains(p.getProperty("secureLink")), "Login Failed");
		Reporter.log("Test:1 Login with correct credentials tested successfully!");
	}


	@Test(priority=2, description = "Testing login with incorrect credentails")
	public void testLoginfailure(){
		Reporter.log("Test:2 Testing login with wrong credentials started"); 
		LoginPage objLogin = new LoginPage(driver);
		objLogin.navigateToUrl(p.getProperty("loginURL"));
		
		//passing empty to test login failure
		objLogin.loginToInternet("",""); 
		Assert.assertTrue(objLogin.getLoginMessage().getText().contains(p.getProperty("loginFailedMessage")));
		
		//passing wrong username
		objLogin.loginToInternet(p.getProperty("randomKeyword"),p.getProperty("password")); 
		Assert.assertTrue(objLogin.getLoginMessage().getText().contains(p.getProperty("loginFailedMessage")));
		
		//passing wrong password but correct username
		objLogin.loginToInternet(p.getProperty("username"),p.getProperty("randomKeyword"));
		Assert.assertTrue(objLogin.getLoginMessage().getText().contains(p.getProperty("wrongPasswordMessage")));
		
		Reporter.log("Test:2 Login with wrong credentials tested successfully!");
	}

	@Test(priority = 3, description = "Testing checking and unchecking checkboxes")
	public void testCheckBoxes() {
		Reporter.log("Test:3 Testing actions on checkboxes started");
		CheckBox cbObject = new CheckBox(driver);
		cbObject.navigateToUrl(p.getProperty("checkboxURL"));

		cbObject.unselectCheckBoxes();

		cbObject.clickCheckBox1();
		Assert.assertTrue(cbObject.isBox1Checked());
		cbObject.clickCheckBox2();
		Assert.assertTrue(cbObject.isBox2Checked());

		cbObject.clickCheckBox1();
		Assert.assertFalse(cbObject.isBox1Checked());
		cbObject.clickCheckBox2();
		Assert.assertFalse(cbObject.isBox2Checked());
		Reporter.log("Test:3 Checkboxes tested successfully!");
	}

	@Test(priority = 4, description = "Testing context menu")
	public void testContextMenu() {
		Reporter.log("Test:4 Testing actions on context menu started");
		ContextMenuPage cmp = new ContextMenuPage(driver);
		cmp.navigateToUrl(p.getProperty("contextMenuURL"));

		cmp.performRightClickOnHotspot();
		String message = cmp.getJSAlertMessage();
		Assert.assertTrue(message.equals(p.getProperty("contextMenuMessage")));
		Reporter.log("Test:4 Testing context menu successful");

	}

	@Test(priority = 5, description = "Testing Drag and Drop")
	public void testDragAndDrop() {
		Reporter.log("Test:5 Testing drag and drop action started");
		DragAndDropPage dpage = new DragAndDropPage(driver);
		dpage.navigateToUrl(p.getProperty("dragAndDropURL"));

		dpage.performDragAndDrop();
		String columnAText = dpage.getcolumnAText();
		String columnBText = dpage.getcolumnBText();
		Assert.assertTrue(columnAText.equals("B"));
		Assert.assertTrue(columnBText.equals("A"));
		Reporter.log("Test:5 Tested drag and drop successfully");
	}

	@Test(priority = 6, description = "Testing DropDown")
	public void testDropdown() {
		Reporter.log("Test:6 Testing dropdown started");

		DropDownPage dropDownPage = new DropDownPage(driver);

		dropDownPage.navigateToUrl(p.getProperty("dropdownURL"));
		String response = dropDownPage.fetchSelectedOption(p.getProperty("dropdownTextOne"));
		Assert.assertEquals(response, p.getProperty("dropdownTextOne"));
		response = dropDownPage.fetchSelectedOption(p.getProperty("dropdownTextTwo"));
		Assert.assertEquals(response, p.getProperty("dropdownTextTwo"));
		Reporter.log("Test:6 Tested dropdown successfully");

	}


	@Test(priority = 7, description = "Testing Dynamic Content in the Page")
	public void testDynamicContent() {

		Reporter.log("Test:7 Testing Dynamic content started");
		DynamicContentPage dcp = new DynamicContentPage(driver);
		dcp.navigateToUrl(p.getProperty("dynamicContentURL"));
		String pageSource1 = dcp.fetchPageSource();
		dcp.refreshPage();
		String pageSource2 = dcp.fetchPageSource();
		Assert.assertFalse(pageSource1.equals(pageSource2));
		Reporter.log("Test:7 Tested dynamic content successfully");
	}

	@Test(priority = 8, description = "Testing Dynamic Controls in the Page")
	public void testDynamicControls() {
		Reporter.log("Test:8 Testing Dynamic controls started");
		DynamicControlsPage dcp = new DynamicControlsPage(driver);

		dcp.navigateToUrl(p.getProperty("dynamicControlURL"));
		dcp.clickAddRemoveButton();
		String text = dcp.returnMessageDisplayed();
		Assert.assertEquals(text, p.getProperty("removedMessage"));

		dcp.clickAddRemoveButton();
		text = dcp.returnMessageDisplayed();
		Assert.assertEquals(text, p.getProperty("checkboxBackMessage"));

		dcp.clickEnableDisableButton();
		Assert.assertTrue(dcp.isTextBoxEnabled());

		dcp.clickEnableDisableButton();
		Assert.assertFalse(dcp.isTextBoxEnabled());
		Reporter.log("Test:8 Tested dynamic controls successfully");
	}

	@Test(priority = 9, description = "Testing Dynamic Loading")
	public void testDynamicLoading() {
		Reporter.log("Test:9 Testing dynamic loading started");
		DynamicLoadingPage dlp = new DynamicLoadingPage(driver);

		dlp.navigateToUrl(p.getProperty("dynamicLoadingURL"));
		dlp.clickStartButton();
		Assert.assertEquals(dlp.fetchHelloTextIfDisplayed(),
				p.getProperty("dynamicLoadingHelloMessage"));
		Reporter.log("Test:9 Tested dynamic loading successfully");

	}

	@Test(priority = 10, description = "Testing File Download")
	public void testFileDownload() {
		Reporter.log("Test:10 Testing file download started");
		FileDownloadPage fdp = new FileDownloadPage(driver);
		fdp.navigateToUrl(p.getProperty("downloadURL"));
		fdp.downloadFile(p.getProperty("filename"));
		Assert.assertTrue(fdp.isFileDownloaded(p.getProperty("fileDownloadPath")));
		Reporter.log("Test:10 Tested file download successfully");
	}


	@Test(priority = 11, description = "Testing File Upload")
	public void testFileUpload() {
		Reporter.log("Test:11 Testing file upload started");
		FileUploadPage fup = new FileUploadPage(driver);
		fup.navigateToUrl(p.getProperty("uploadURL"));
		fup.uploadFile(p.getProperty("uploadPath"));
		fup.uploadButtonClick();
		Assert.assertTrue(fup.isFileUploaded(p.getProperty("fileUploadedMessage")));
		Reporter.log("Test:11 Tested file upload successfully");
	}

	@Test(priority = 12, description = "Testing Floating Header")
	public void testFloatingMenu() {
		Reporter.log("Test:12 Testing floating header started");
		FloatingMenuPage fmt = new FloatingMenuPage(driver);
		fmt.navigateToUrl(p.getProperty("floatingHeaderURL"));
		fmt.scrollPageToBottom();
		Assert.assertTrue(fmt.isMenuDisplayed());
		Reporter.log("Test:12 Tested floating header successfully");

	}

	@Test(priority = 13, description = "Testing iFrame Input")
	public void testiFrame() {
		Reporter.log("Test:13 Testing iframe input started");
		IframePage iframePage = new IframePage(driver);
		iframePage.navigateToUrl(p.getProperty("iframeURL"));
		iframePage.activateIframe();
		iframePage.clearExistingText();
		iframePage.setText(p.getProperty("sampleTextHello"));
		Assert.assertEquals(iframePage.getText(), p.getProperty("sampleTextHello"));
		Reporter.log("Test:13 Tested iframe input successfully");
	}


	@Test(priority = 14, description = "Testing MouseHover")
	public void testMouseHover() {
		Reporter.log("Test:14 Testing mouse hover action started");
		MouseHoverPage mhp = new MouseHoverPage(driver);
		mhp.navigateToUrl(p.getProperty("hoverURL"));		
		Assert.assertTrue(mhp.isInfoDisplayed());
		Reporter.log("Test:14 Tested mouse hover action successfully");
	}

	@Test(priority = 15, description = "Testing JS Alerts")
	public void testjsAlerts() {
		Reporter.log("Test:15 Testing js alerts started");
		JavascriptAlertsPage jsAlertsPage = new JavascriptAlertsPage(driver);
		jsAlertsPage.navigateToUrl(p.getProperty("jsAlertsURL"));

		jsAlertsPage.clickJsAlertButton();
		Assert.assertEquals(jsAlertsPage.getJsMessage(), p.getProperty("alertButtonMessage"));

		jsAlertsPage.clickJsConfirmButton();
		Assert.assertEquals(jsAlertsPage.getJsMessage(), p.getProperty("confirmButtonMessage"));

		jsAlertsPage.clickJsPromptButton();
		jsAlertsPage.SendMessagejsPrompt(p.getProperty("sampleHelloText"));
		Assert.assertEquals(jsAlertsPage.getResultMessage(), p.getProperty("expectedMessage"));
		Reporter.log("Test:15 Tested js alerts successfully");

	}

	@Test(priority = 16, description = "Testing JS Errors")
	public void testjsError() {
		Reporter.log("Test:16 Testing js errors started");
		JavascriptErrorPage jsError = new JavascriptErrorPage(driver);
		jsError.navigateToUrl(p.getProperty("jsErrorURL"));

		Assert.assertTrue(jsError.getErrorMessage()
				.contains(p.getProperty("expectedErrorString")));
		Reporter.log("Test:16 Tested js errors successfully");
	}

	@Test(priority = 17, description = "New Tab Test")
	public void testNewTab() {
		Reporter.log("Test:17 Testing new tab open function started");
		NewTabPage newPage = new NewTabPage(driver);
		newPage.navigateToUrl(p.getProperty("newTabURL"));
		newPage.clickOnNewTabLink();
		newPage.switchToNewTab();

		Assert.assertEquals(driver.getTitle(), p.getProperty("expectedTitle"));
		Reporter.log("Test:17 Tested new tab function successfully");
	}

	@Test(priority = 18, description = "Testing Notification Page")
	public void testNotification() {
		Reporter.log("Test:18 Testing notification started");
		NotificationPage notificationPage = new NotificationPage(driver);
		notificationPage.navigateToUrl(p.getProperty("notificationURL"));
		int timesClicked = Integer.parseInt(p.getProperty("timesClicked"));

		Assert.assertTrue(notificationPage.isMessageReturnedForClicks(timesClicked));
		Reporter.log("Test:18 Tested notification page successfully");
	}






}


