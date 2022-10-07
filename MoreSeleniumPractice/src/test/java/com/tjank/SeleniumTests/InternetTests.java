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
	
	@Test(enabled = false)
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
	
	@Test(enabled = false) 
	public void unhappyPathLogin() {
		InternetLoginPage loginPage = new InternetLoginPage();
		loginPage.setup();
		loginPage.waitForPageToLoad();
		loginPage.login("bad", "pass");
		loginPage.waitForLoginToFail();
		Assert.assertTrue(loginPage.getLoginFailedMessage().contains("Your username is invalid!"));
	}
	
	@Test(enabled = false)
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
	
	@Test(enabled = false)
	public void contextMenuTest() {
		ContextMenuPage contextMenuPage = new ContextMenuPage();
		contextMenuPage.setup();
		contextMenuPage.waitForPageToLoad();
		contextMenuPage.rightClickContextMenu();
		contextMenuPage.waitForAlertToDisplay();
		contextMenuPage.verifyAlertText();
	}
	
	@Test(enabled = false)
	public void dragAndDropTest() {
		DragAndDropPage dndPage = new DragAndDropPage();
		dndPage.setup();
		dndPage.waitForPageToLoad();
		dndPage.dragAndDrop();
		dndPage.verifyElementSwitch();
	}
	
	@Test(enabled = false)
	public void dropdownTest() {
		DropdownPage dropdownPage = new DropdownPage();
		dropdownPage.setup();
		dropdownPage.waitForPageToLoad();
		dropdownPage.selectDropdownOption("Option 1");
		dropdownPage.selectDropdownOption("Option 2");
	}
	
	@Test(enabled = false)
	public void dynamicContentTest() {
		DynamicContentPage contentPage = new DynamicContentPage();
		contentPage.setup();
		contentPage.waitForPageToLoad();
		ArrayList<String> list = contentPage.getTextCols();
		contentPage.refreshPage();
		contentPage.checkForDuplicateCols(list);
	}
	
	@Test(enabled = false)
	public void dynamicControlsTest() {
		DynamicControlsPage dynPage = new DynamicControlsPage();
		dynPage.setup();
		dynPage.waitForPageToLoad();
		dynPage.clickRemoveButton();
		dynPage.clickAddButton();
		dynPage.clickEnableButton();
		dynPage.clickDisableButton();
	}
	
	@Test(enabled = false)
	public void dynamicLoadingTest() {
		DynamicLoadingPage dynPage = new DynamicLoadingPage();
		dynPage.setup();
		dynPage.waitForPageToLoad();
		dynPage.clickStartButton();
	}
	
	@Test(enabled = false)
	public void fileDownloadTest() {
		FileDownloadPage dnPage = new FileDownloadPage();
		dnPage.setup();
		dnPage.waitForPageToLoad();
		dnPage.downloadFile();
		dnPage.verifyFileDownloaded();
	}
	
	@Test(enabled = false)
	public void uploadFileTest() {
		FileUploadPage fupPage = new FileUploadPage();
		fupPage.setup();
		fupPage.waitForPageToLoad();
		fupPage.uploadFile("some-file.txt");
		fupPage.verifyFileUploaded("some-file.txt");
	}
	
	@Test(enabled = false)
	public void floatingMenutest() {
		FloatingMenuPage fmPage = new FloatingMenuPage();
		fmPage.setup();
		fmPage.waitForPageToLoad();
		fmPage.scrollDown();
		fmPage.verifyFloatMenu();
	}
	
	@Test(enabled = false)
	public void iframeTest() {
		IFramePage frPage = new IFramePage();
		frPage.setup();
		frPage.waitForPageToLoad();
		frPage.clickXSymbol();
		frPage.typeText();
	}
	
	@Test(enabled = false)
	public void hoverTest() {
		MouseHoverPage hoverPage = new MouseHoverPage();
		hoverPage.setup();
		hoverPage.waitForPageToLoad();
		hoverPage.verifyImageText(hoverPage.getImages());
	}
	
	@Test(enabled = false)
	public void jsAlertTest() {
		JavascriptAlertsPage jsPage = new JavascriptAlertsPage();
		jsPage.setup();
		jsPage.waitForPageToLoad();
		jsPage.verifyAlertMessage();
		jsPage.verifyAlertConfirm();
		jsPage.verifyAlertPrompt();
	}
	
	@Test(enabled = false)
	public void jsErrorPageTest() {
		JavascriptErrorPage erPage = new JavascriptErrorPage();
		erPage.setup();
		erPage.waitForPageToLoad();
		erPage.validateErrorMessage();
	}
	
	@Test(enabled = false)
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
