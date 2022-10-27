package kumarPoswal.salinder1;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.DynamicControls;
import com.takeHomeTest.pages.TheInternetPage;

public class DynamicControlsTest extends TestBase {

	DynamicControls dynamicControls;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void disableCheckBoxTest() throws InterruptedException {
		dynamicControls = theInternetPage.clickDynamicControltBtn();
		if (dynamicControls.getRemoveOrAddButtonText().equals("Remove")) {
			dynamicControls.ClickRemoveAddButton();
		} else {
			dynamicControls.ClickRemoveAddButton();
			new WebDriverWait(webDriver, 10000)
					.until(ExpectedConditions.textToBe(dynamicControls.getRemoveOrAddButton(), "Add"));
			dynamicControls.ClickRemoveAddButton();

		}

		Assert.assertEquals(dynamicControls.getMessageText("Disappear"), "It's gone!");
	}

	@Test
	public void enableCheckBoxTest() {
		dynamicControls = theInternetPage.clickDynamicControltBtn();

		if (dynamicControls.getRemoveOrAddButtonText().equals("Remove")) {
			dynamicControls.ClickRemoveAddButton();
			new WebDriverWait(webDriver, 10000)
					.until(ExpectedConditions.textToBe(dynamicControls.getRemoveOrAddButton(), "Add"));
			dynamicControls.ClickRemoveAddButton();
		} else {
			dynamicControls.ClickRemoveAddButton();
		}
		Assert.assertEquals(dynamicControls.getMessageText("Appear"), "It's back!");
	}
	
	@Test
	public void TextBoxEnabledTest() {
		dynamicControls = theInternetPage.clickDynamicControltBtn();
		if (dynamicControls.getEnableButtonText().equals("Disable")) {
			dynamicControls.ClickEnableButton();
		} else {
			dynamicControls.ClickEnableButton();
			new WebDriverWait(webDriver, 10000)
					.until(ExpectedConditions.textToBe(dynamicControls.getEnableButton(), "Disable"));
			dynamicControls.ClickEnableButton();
		}
		Assert.assertEquals(dynamicControls.isTestBoxEnabled(), true);
	}

	@Test
	public void verifyTextBoxDisabledTest() {
		dynamicControls = theInternetPage.clickDynamicControltBtn();
		if (dynamicControls.getEnableButtonText().equals("Enable")) {
			dynamicControls.ClickEnableButton();
		} else {
			dynamicControls.ClickEnableButton();
			new WebDriverWait(webDriver, 10000)
					.until(ExpectedConditions.textToBe(dynamicControls.getEnableButton(), "Enable"));
			dynamicControls.ClickEnableButton();
		}
		Assert.assertEquals(dynamicControls.isTestBoxEnabled(), false);
	}
	
	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
