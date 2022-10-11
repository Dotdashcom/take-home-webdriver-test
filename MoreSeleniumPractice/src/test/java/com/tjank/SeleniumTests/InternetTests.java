package com.tjank.SeleniumTests;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.CheckboxPage;
import com.tjank.PageObjectModel.ContextMenuPage;
import com.tjank.PageObjectModel.DragAndDropPage;
import com.tjank.PageObjectModel.DropdownPage;
import com.tjank.PageObjectModel.DynamicContentPage;
import com.tjank.PageObjectModel.DynamicControlsPage;
import com.tjank.PageObjectModel.DynamicLoadingPage;
import com.tjank.PageObjectModel.FileDownloadPage;
import com.tjank.PageObjectModel.FileUploadPage;
import com.tjank.PageObjectModel.FloatingMenuPage;
import com.tjank.PageObjectModel.IFramePage;
import com.tjank.PageObjectModel.InternetLoginPage;
import com.tjank.PageObjectModel.JavascriptAlertsPage;
import com.tjank.PageObjectModel.JavascriptErrorPage;
import com.tjank.PageObjectModel.MouseHoverPage;
import com.tjank.PageObjectModel.NewTabPage;
import com.tjank.PageObjectModel.NotificationMessagePage;
import com.tjank.PageObjectModel.SecurePage;
import com.tjank.PageObjectModel.WebPage;

public class InternetTests {
	
	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test(priority = 1)
	public void happyPathLogin() {
		InternetLoginPage loginPage = new InternetLoginPage();
		loginPage.setup();
		loginPage.waitForPageToLoad();
		loginPage.login("tomsmith", "SuperSecretPassword!");
		SecurePage securePage = new SecurePage();
		securePage.waitForSuccesfulLogin();
		Assert.assertEquals(securePage.getSecureText(), "Welcome to the Secure Area. When you are done click logout below.");
		securePage.clickLogoutButton();
	}
	
	@Test(priority = 2) 
	public void unhappyPathLogin() {
		InternetLoginPage loginPage = new InternetLoginPage();
		loginPage.setup();
		loginPage.waitForPageToLoad();
		loginPage.login("bad", "pass");
		loginPage.waitForLoginToFail();
		Assert.assertTrue(loginPage.getLoginFailedMessage().contains("Your username is invalid!"));
	}
	
	@Test(priority = 3)
	public void checkboxTest() {
		CheckboxPage checkboxPage = new CheckboxPage();
		checkboxPage.setup();
		checkboxPage.waitForPageToLoad();
		Assert.assertFalse(checkboxPage.checkBoxOne.isSelected());
		Assert.assertTrue(checkboxPage.checkBoxTwo.isSelected());
		checkboxPage.clickFirstCheckbox();
		checkboxPage.clickSecondCheckbox();
		Assert.assertTrue(checkboxPage.checkBoxOne.isSelected());
		Assert.assertFalse(checkboxPage.checkBoxTwo.isSelected());
	}
	
	@Test(priority = 4)
	public void contextMenuTest() {
		ContextMenuPage contextMenuPage = new ContextMenuPage();
		contextMenuPage.setup();
		contextMenuPage.waitForPageToLoad();
		contextMenuPage.rightClickContextMenu();
		contextMenuPage.waitForAlertToDisplay();
		contextMenuPage.verifyAlertText();
	}
	
	@Test(priority = 5)
	public void dragAndDropTest() {
		DragAndDropPage dndPage = new DragAndDropPage();
		dndPage.setup();
		dndPage.waitForPageToLoad();
		dndPage.dragAndDrop();
		dndPage.verifyElementSwitch();
	}
	
	@Test(priority = 6)
	public void dropdownTest() {
		DropdownPage dropdownPage = new DropdownPage();
		dropdownPage.setup();
		dropdownPage.waitForPageToLoad();
		dropdownPage.selectDropdownOption("Option 1");
		dropdownPage.selectDropdownOption("Option 2");
	}
	
	@Test(priority = 7)
	public void dynamicContentTest() {
		DynamicContentPage contentPage = new DynamicContentPage();
		contentPage.setup();
		contentPage.waitForPageToLoad();
		ArrayList<String> list = contentPage.getTextCols();
		contentPage.refreshPage();
		contentPage.checkForDuplicateCols(list);
	}
	
	@Test(priority = 8)
	public void dynamicControlsTest() {
		DynamicControlsPage dynPage = new DynamicControlsPage();
		dynPage.setup();
		dynPage.waitForPageToLoad();
		dynPage.clickRemoveButton();
		dynPage.clickAddButton();
		dynPage.clickEnableButton();
		dynPage.clickDisableButton();
	}
	
	@Test(priority = 9)
	public void dynamicLoadingTest() {
		DynamicLoadingPage dynPage = new DynamicLoadingPage();
		dynPage.setup();
		dynPage.waitForPageToLoad();
		dynPage.clickStartButton();
	}
	
	@Test(priority = 10)
	public void fileDownloadTest() {
		FileDownloadPage dnPage = new FileDownloadPage();
		dnPage.setup();
		dnPage.waitForPageToLoad();
		dnPage.downloadFile();
		dnPage.verifyFileDownloaded();
	}
	
	@Test(priority = 11)
	public void uploadFileTest() {
		FileUploadPage fupPage = new FileUploadPage();
		fupPage.setup();
		fupPage.waitForPageToLoad();
		fupPage.uploadFile("some-file.txt");
		fupPage.verifyFileUploaded("some-file.txt");
	}
	
	@Test(priority = 12)
	public void floatingMenutest() {
		FloatingMenuPage fmPage = new FloatingMenuPage();
		fmPage.setup();
		fmPage.waitForPageToLoad();
		fmPage.scrollDown();
		fmPage.verifyFloatMenu();
	}
	
	@Test(priority = 13)
	public void iframeTest() {
		IFramePage frPage = new IFramePage();
		frPage.setup();
		frPage.waitForPageToLoad();
		frPage.clickXSymbol();
		frPage.typeText();
	}
	
	@Test(priority = 14)
	public void hoverTest() {
		MouseHoverPage hoverPage = new MouseHoverPage();
		hoverPage.setup();
		hoverPage.waitForPageToLoad();
		hoverPage.verifyImageText(hoverPage.getImages());
	}
	
	@Test(priority = 15)
	public void jsAlertTest() {
		JavascriptAlertsPage jsPage = new JavascriptAlertsPage();
		jsPage.setup();
		jsPage.waitForPageToLoad();
		jsPage.verifyAlertMessage();
		jsPage.verifyAlertConfirm();
		jsPage.verifyAlertPrompt();
	}
	
	@Test(priority = 16)
	public void jsErrorPageTest() {
		JavascriptErrorPage erPage = new JavascriptErrorPage();
		erPage.setup();
		erPage.waitForPageToLoad();
		erPage.validateErrorMessage();
	}
	
	@Test(priority = 17)
	public void newTabTest() {
		NewTabPage tabPage = new NewTabPage();
		tabPage.setup();
		tabPage.waitForPageToLoad();
		tabPage.clickLink();
		tabPage.switchToNewTab();
		tabPage.verifyNewTabOpened();
	}
	
	@Test(priority = 18)
	public void notificationTest() {
		NotificationMessagePage notPage = new NotificationMessagePage();
		notPage.setup();
		notPage.waitForPageToLoad();
		notPage.clickLink();
		notPage.verifyNotificationMessage();
	}
}
