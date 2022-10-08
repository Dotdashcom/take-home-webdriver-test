package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import foundation.dotDashTestBase;
import pages.AccountPage;
import pages.CheckboxPage;
import pages.ContextMenuPage;
import pages.DownloadPage;
import pages.DragDropPage;
import pages.DropdownPage;
import pages.DynamicContentPage;
import pages.DynamicControlsPage;
import pages.DynamicLoadingPage;
import pages.FloatingMenuPage;
import pages.IFramePage;
import pages.JSAlertsPage;
import pages.LoginPage;
import pages.MouseHoverPage;
import pages.NewTabPage;
import pages.NotificationPage;
import pages.UploadPage;

public class dotDashTests extends dotDashTestBase{

	@Test
	public void userCanLogin() {

		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		String expectedLoginMessage = "You logged into a secure area!";

		new LoginPage(getDriver(), getBaseUrl())
		.navigate()
		.enterUserName(username)
		.enterPassword(password)
		.clickLoginButton();
		String actualLoginMessage = new AccountPage(getDriver(), getBaseUrl())
				.successfulLoginMessage();

		assertTrue(actualLoginMessage.contains(expectedLoginMessage));
	}

	@Test
	public void userCannotLogin() {

		String username = "tommysmith";
		String password = "KindveSecretPassword";
		String expectedErrorMessage = "Your username is invalid!";

		String actualErrorMessage = new LoginPage(getDriver(), getBaseUrl())
				.navigate()
				.enterUserName(username)
				.enterPassword(password)
				.clickLoginButton()
				.errorMessage();

		assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	}

	@Test
	public void canCheckAndUncheckBoxes() {

		new CheckboxPage(getDriver(), getBaseUrl())
		.navigate()
		.returnStatusOfCheckboxes()
		.checkFirstChechbox()
		.uncheckSecondCheckbox()
		.returnStatusOfCheckboxes();

		WebElement checkbox1 = this.getDriver().findElement(By.xpath("//input[@type='checkbox'][position()=1]"));
		WebElement checkbox2 = this.getDriver().findElement(By.xpath("//input[@type='checkbox'][position()=2]"));

		assertEquals(checkbox1.isSelected(), true, "Error: the first checkbox should now be checked.");
		assertEquals(checkbox2.isSelected(), false, "Error: the second checkbox should now be unchecked.");
	}

	@Test
	public void canRightClickContextMenu() {

		String expectedAlertMessage = "You selected a context menu";

		String actualAlertMessage = new ContextMenuPage(getDriver(), getBaseUrl())
				.navigate()
				.rightClickMenu()
				.returnAlertMessage();

		assertTrue(actualAlertMessage.contains(expectedAlertMessage));
	}

	@Test
	public void canDragAndDropElement() {

		new DragDropPage(getDriver(), getBaseUrl())
		.navigate()
		.currentLocation()
		.moveBoxA()
		.currentLocation();
	}

	@Test
	public void canSelectOptionsFromDropdownList() {

		String option1 = "Option 1";
		String option2 = "Option 2";

		String firstSelection =	new DropdownPage(getDriver(), getBaseUrl())
				.navigate()
				.selectOption(option1);

		assertEquals(option1, firstSelection);

		String secondSelection = new DropdownPage(getDriver(), getBaseUrl())
				.selectOption(option2);

		assertEquals(option2, secondSelection);
	}

	@Test
	public void canChangeContentByRefreshingPage() {

		String contentBeforeRefresh = new DynamicContentPage(getDriver(), getBaseUrl())
				.navigate()
				.returnFirstParagraph();

		String contentAfterRefresh = new DynamicContentPage(getDriver(), getBaseUrl())
				.refreshPage()
				.refreshPage()
				.refreshPage()
				.returnFirstParagraph();

		assertNotEquals(contentBeforeRefresh, contentAfterRefresh);
	}

	@Test
	public void canRemoveCheckbox() {

		new DynamicControlsPage(getDriver(), getBaseUrl())
		.navigate()
		.clickRemoveButton();

		boolean checkbox = this.getDriver().findElements(By.xpath("//input[@type='checkbox']")).isEmpty();
		assertTrue(checkbox);
	}

	@Test
	public void canAddCheckbox() {

		new DynamicControlsPage(getDriver(), getBaseUrl())
		.navigate()
		.clickRemoveButton()
		.clickAddButton();

		WebElement checkbox = this.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		assertTrue(checkbox != null);
	}

	@Test
	public void canEnableTextBox() {

		new DynamicControlsPage(getDriver(), getBaseUrl())
		.navigate()
		.clickEnableButton();

		WebElement textBox = this.getDriver().findElement(By.xpath("//form[@id='input-example']//button[@type='button']"));
		assertTrue(textBox.isEnabled());
	}

	@Test
	public void canDisableTextBox() {

		new DynamicControlsPage(getDriver(), getBaseUrl())
		.navigate()
		.clickEnableButton()
		.clickDisableButton();

		WebElement textBox = this.getDriver().findElement(By.xpath("//form[@id='input-example']//button[@type='button']"));
		assertFalse(textBox.isEnabled());
	}

	@Test
	public void canDisplayHelloWorld() {

		String expectedMessage = "Hello World!";

		String actualMessage = new DynamicLoadingPage(getDriver(), getBaseUrl())
				.navigate()
				.clickStartButton()
				.retrieveDisplayedMessage();

		assertEquals(actualMessage, expectedMessage);
	}

	@Test
	public void canDownloadFile() {

		String path = "/Users/gssiler7/Downloads";
		String fileName = "/some-file.txt";

		Boolean fileIsDownloaded = new DownloadPage(getDriver(), getBaseUrl())
				.navigate()
				.clickFile()
				.verifyFileWasDownloaded(path, fileName);

		assertTrue(fileIsDownloaded);
	}

	@Test
	public void canUploadFile() {

		String expectedConfirmation = "File Uploaded!";

		String actualConfirmation = new UploadPage(getDriver(), getBaseUrl())
				.navigate()
				.chooseFile()
				.clickUploadButton();

		assertTrue(actualConfirmation.contains(expectedConfirmation));
	}

	@Test
	public void canDisplyFloatingMenuAfterScrolling() {

		new FloatingMenuPage(getDriver(), getBaseUrl())
		.navigate()
		.scrollToBottomOfPage();

		WebElement floatingMenu = this.getDriver().findElement(By.xpath("//div[@id='menu']"));
		assertTrue(floatingMenu.isDisplayed());
	}

	@Test
	public void canTypeTextInIFrame() {

		String expectedText = "abcd12345";

		new IFramePage(getDriver(), getBaseUrl())
		.navigate()
		.accessIFrame(expectedText);

		String actualText = this.getDriver().findElement(By.xpath("//body[@id='tinymce']")).getText();
		assertEquals(actualText, expectedText);
	}

	@Test
	public void canHoverOverPicture() {

		new MouseHoverPage(getDriver(), getBaseUrl())
		.navigate()
		.hoverPicture(1);

		WebElement additionalInfo1 = this.getDriver().findElement(By.xpath("//div[@class='figure'][position()=1]//div[@class='figcaption']"));
		assertTrue(additionalInfo1.isDisplayed());

		new MouseHoverPage(getDriver(), getBaseUrl())
		.navigate()
		.hoverPicture(2);

		WebElement additionalInfo2 = this.getDriver().findElement(By.xpath("//div[@class='figure'][position()=2]//div[@class='figcaption']"));
		assertTrue(additionalInfo2.isDisplayed());

		new MouseHoverPage(getDriver(), getBaseUrl())
		.navigate()
		.hoverPicture(3);

		WebElement additionalInfo3 = this.getDriver().findElement(By.xpath("//div[@class='figure'][position()=3]//div[@class='figcaption']"));
		assertTrue(additionalInfo3.isDisplayed());
	}

	@Test
	public void canProcessJavaScriptAlerts() {

		String expectedJSAlert = "I am a JS Alert";
		String expectedJSConfirm = "I am a JS Confirm";
		String expectedJSPrompt = "Charlotte";

		new JSAlertsPage(getDriver(), getBaseUrl())
		.navigate()
		.clickAlertButton();

		String actualJSAlert = driver.switchTo().alert().getText();
		assertEquals(actualJSAlert, expectedJSAlert);

		driver.switchTo().alert().accept();

		new JSAlertsPage(getDriver(), getBaseUrl())
		.clickConfirmButton();

		String actualJSConfirm = driver.switchTo().alert().getText();
		assertEquals(actualJSConfirm, expectedJSConfirm);

		driver.switchTo().alert().accept();

		new JSAlertsPage(getDriver(), getBaseUrl())
		.clickPromptButton();

		driver.switchTo().alert().sendKeys(expectedJSPrompt);
		driver.switchTo().alert().accept();

		String actualJSPrompt = this.getDriver().findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(actualJSPrompt);
		assertTrue(actualJSPrompt.contains(expectedJSPrompt));
	}

	@Test
	public void canOpenNewTab() {

		String expectedText = "New Window";

		String actualText = new NewTabPage(getDriver(), getBaseUrl())
				.navigate()
				.clickLink()
				.retrieveText();

		assertEquals(actualText, expectedText);
	}

	@Test
	public void canRetrieveNotificationMessage() {

		String notification1 = "Action Successful";
		String notification2 = "Action unsuccessful, please try again";
		String notification3 = "Action Unsuccessful";

		new NotificationPage(getDriver(), getBaseUrl())
		.navigate()
		.clickLink()
		.clickLink()
		.clickLink()
		.clickLink();

		String actualNotification = this.getDriver().findElement(By.xpath("//div[@id='flash']")).getText();

		if (actualNotification == notification1) {
			assertTrue(actualNotification.contains(notification1));
		} else if (actualNotification == notification2) {
			assertTrue(actualNotification.contains(notification2));
		} else if (actualNotification == notification3) {
			assertTrue(actualNotification.contains(notification3));
		}
		System.out.println(actualNotification);

	}

}
