package com.test.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage lp;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
	}

	@Test(priority = 1)
	public void loginTest() {
		driver.get(prop.getProperty("url"));
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(prop.getProperty("loginsuccessmsg"), "You logged into a secure area!");
	}

	@Test(priority = 2)
	public void loginTestWithWrongInputs() {
		driver.get(prop.getProperty("url"));
		lp.login(prop.getProperty("wrnguser"), prop.getProperty("wrngpass"));
		Assert.assertEquals(prop.getProperty("errorMsg"), "Your username is invalid!");
	}

	@Test(priority = 3)
	public void checkBoxValidation() {
		driver.get(prop.getProperty("CheckBoxesurl"));
		boolean flag = lp.verifyCheckboxes();
		Assert.assertTrue(flag);
	}

	@Test(priority = 4)
	public void checkBoxValidationWithInput() {
		driver.get(prop.getProperty("CheckBoxesurl"));
		boolean flag = lp.verifyCheckboxesWithInput();
		Assert.assertFalse(flag);
	}

	@Test(priority = 5)
	public void alertValidationTest() throws InterruptedException {
		driver.get(prop.getProperty("ContextMenuurl"));
		String alertText = lp.alertValidation();
		Assert.assertEquals(prop.getProperty("alertText"), alertText);
	}

	@Test(priority = 6)
	public void dragAndDropTest() throws InterruptedException {
		driver.get(prop.getProperty("DragAndDropurl"));
		String elementBText = lp.dragAndDropValidation();
		Assert.assertEquals(prop.getProperty("elementBText"), elementBText);
	}

	@Test(priority = 7)
	public void dropDownTest() throws InterruptedException {
		driver.get(prop.getProperty("Dropdownurl"));
		lp.dropDownValidation();
		Assert.assertEquals(prop.getProperty("dropDownOption1"), lp.text1);
		Assert.assertEquals(prop.getProperty("dropDownOption2"), lp.text2);

	}

	@Test(priority = 8)
	public void dynamicContentTest() {
		driver.get(prop.getProperty("DynamicContenturl"));
		lp.dynamicContentValidation();
		Assert.assertFalse(dynamicContentText1.equalsIgnoreCase(dynamicContentText2));

	}

	@Test(priority = 9)
	public void dynamicLoadingClickValidationTest() {
		driver.get(prop.getProperty("DynamicLoadingurl"));
		lp.dynamicLoadingClickValidation();
		Assert.assertEquals(dynamicLoadingText1, prop.getProperty("dynamicText"));

	}

	@Test(priority = 10)
	public void fileDownloadValidationTest() throws InterruptedException {
		driver.get(prop.getProperty("FileDownloadurl"));
		lp.fileDownloadValidation();
		Assert.assertTrue(lp.isFileDownloaded("C:\\Users\\14169\\Downloads", "some-file.txt"),
				"Failed to download Expected document");

	}



	@Test(priority=12)
	public void frameValidationTest() throws InterruptedException {
		driver.get(prop.getProperty("Frameurl"));
		lp.frameValidation();
	}
	
	@Test(priority=13)
	public void floatingMenuValidationTest() throws InterruptedException {
		driver.get(prop.getProperty("FloatingMenuurl"));
		lp.floatingMenuValidation();
		Assert.assertEquals(text3, prop.getProperty("floatingMenutext"));
		Assert.assertTrue(flag);
	}
	
	@Test(priority=14)
	public void mouseHoverValidationTest() throws InterruptedException {
		driver.get(prop.getProperty("MouseHoverurl"));
		lp.mouseHoverValidation();
		
	}
	
	@Test(priority=15)
	public void javaScriptAlertsValidation() throws InterruptedException {
		driver.get(prop.getProperty("JavaScriptAlertsurl"));
		lp.javaScriptAlertsValidation();
	}
	
	@Test(priority=16)
	public void childWindowValidationTest(){
		driver.get(prop.getProperty("childWindow"));
		lp.childWindowValidation();
	}
	
	@Test(priority=17)
	public void notificationMessageValidationTest() {
		driver.get(prop.getProperty("notificationMessageurl"));
		lp.notificationMessageValidation();
	}
	
	@Test(priority=18)
	public void dynamicControlsValidationTest() {
		driver.get(prop.getProperty("dynamicControlsurl"));
		lp.dynamicControlsValidation();
	}
	
	@Test(priority=19)
	
	public void fileUploadValidationTest() throws InterruptedException {
		driver.get(prop.getProperty("FileUploadurl"));
		lp.fileUploadValidation();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
