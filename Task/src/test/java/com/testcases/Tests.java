package com.testcases;

import com.testbase.PageInitializer;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tests extends PageInitializer {

	
	

	@Test
	// login with valid credentials
	void loginSuccess() {

		setUp("login");

		
		sendText(login.userName, "tomsmith");
		sendText(login.password, "SuperSecretPassword!");
		click(login.loginBtn);
		Assert.assertEquals(login.logout.getText(), "Logout");
		
		tearDown();

	}

	@Test
	// login with invalid credentials
	void loginFailure() {

		setUp("login");

		sendText(login.userName, "johndoe");
		sendText(login.password, "invalidPassword!");
		click(login.loginBtn);
		Assert.assertTrue(login.errorMsg.isDisplayed());
		
		tearDown();

	}

	@Test
	// check and uncheck boxes
	void checkboxes() {

		setUp("checkboxes");

		List<WebElement> chexBoxes = new ArrayList<>(checkBox.checkbox);

		for (WebElement element : chexBoxes) {
			element.click();
			if (element.isSelected()) {
				element.click();
			}

		}

		tearDown();
	}

	
	@Test
	// Right-click in the box to see one called 'the-internet'.
	void contextMenu() {

		setUp("context_menu");

		Actions action = new Actions(driver);
		action.contextClick(contextMenu.hotSpot).perform();

		driver.switchTo().alert().accept();

		tearDown();
	}

	
	@Test
	// Drag and Drop
	void dragAndDrop() {

		setUp("drag_and_drop");

		Actions action = new Actions(driver);
		action.dragAndDrop(dragAndDrop.columnA, dragAndDrop.columnB).build().perform();

		tearDown();
	}

	
	@Test
	// Dropdown
	void dropdown() {

		setUp("dropdown");

		Select select = new Select(ddpage.dropDown);
		select.selectByVisibleText("Option 1");

		tearDown();
	}
	

	@Test
	// Dynamic content
	void dynamicContent() throws InterruptedException {

		setUp("dynamic_content");

		Thread.sleep(2000);

		driver.navigate().refresh();

		tearDown();
	}
	

	@Test
	// Test Dynamic Controls using Explicit Waits
	void dynamicControls() {

		setUp("dynamic_controls");

		click(dyControl.removeAddBtn);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dyControl.removeAddBtn));
		click(dyControl.removeAddBtn);

		wait.until(ExpectedConditions.visibilityOf(dyControl.removeAddBtn));

		tearDown();
	}
	

	@Test
	// Dynamic Loading
	void dynamicLoading() {

		setUp("dynamic_loading/2");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(dLoaded.startBtn));

		click(dLoaded.startBtn);
		wait.until(ExpectedConditions.visibilityOf(dLoaded.finishText));

		Assert.assertEquals(dLoaded.finishText, "Hello World!");

		tearDown();
	}
	

	@Test
	// Test File Download
	void download() {

		setUp("download");

		click(fileDwnld.fileLoc);
		tearDown();
	}

	@Test
	// Test File Upload.
	void upload() throws AWTException {

		setUp("upload");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(fileUpload.chooseFile));

		sendText(fileUpload.chooseFile, "/Users/andrii/Downloads/some-file.txt");

		wait.until(ExpectedConditions.elementToBeClickable(fileUpload.uploadBtn));
		click(fileUpload.uploadBtn);

		Assert.assertEquals(fileUpload.message.getText(), "File Uploaded!" + "\n" + "TextDoc.txt");
		tearDown();
	}

	@Test
	// Test Floating Menu.
	void floatingMenu() {

		setUp("floating_menu");

		boolean condition = false;
		if (flMenu.floatingMenu.getText().contains("Floating Menu")) {
			condition = true;
		}
		Assert.assertEquals(condition, true);
		tearDown();
	}

	@Test
	// Test iframe
	void iframe() {

		setUp("iframe");

		driver.switchTo().frame(iFrame.iFrame);
		iFrame.contentBody.clear();
		sendText(iFrame.contentBody, "Hello World!");
		tearDown();
	}

	@Test
	// Test confirm JS Alert
	void javascriptAlerts() {

		setUp("javascript_alerts");

		click(jsClick.clickJSAlert);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		click(jsClick.clickJSConfirm);
		alert.dismiss();

		click(jsClick.clickJSPrompt);
		alert.sendKeys("Random Text");
		alert.accept();
		tearDown();
	}

	@Test
	// Test JS error.
	void javascriptError() {

		setUp("javascript_error");

		boolean condition = false;
		if (jsError.errorMessage.getText().contains("JavaScript error")) {
			condition = true;
		}
		Assert.assertEquals(condition, true);
		tearDown();
	}

	@Test
	// New Window Test
	void newWindow() {

		setUp("windows");

		click(newWindow.clickHereBtn);
		switchToChildWindow();

		boolean condition = false;
		if (newWindow.newWindowMessage.getText().contains("New Window")) {
			condition = true;
		}
		Assert.assertEquals(condition, true);
		tearDown();
	}

	@Test
	// Test notification Message.
	void notificationMessage() {

		setUp("notification_message_rendered");

		click(notifMessage.clickHere);

		boolean condition = false;
		if (notifMessage.actMessage.getText().contains("Action")) {
			condition = true;
		}
		Assert.assertEquals(condition, true);
		tearDown();
	}

}
