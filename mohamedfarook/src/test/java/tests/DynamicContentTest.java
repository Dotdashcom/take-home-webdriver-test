package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DynamicContentPage;

public class DynamicContentTest extends BaseClass {
	DynamicContentPage dynContPageObj;

	public DynamicContentTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/dynamic_content");
		dynContPageObj = new DynamicContentPage();
	}

	@Test
	public void CheckDynamicText1() {
		String Text = dynContPageObj.DynamicText1.getText();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		String TextAfterRefresh = dynContPageObj.DynamicText1.getText();
		Assert.assertNotEquals(Text, TextAfterRefresh);
	}

	@Test
	public void CheckDynamicText2() {
		String Text = dynContPageObj.DynamicText2.getText();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		String TextAfterRefresh = dynContPageObj.DynamicText2.getText();
		Assert.assertNotEquals(Text, TextAfterRefresh);
	}

	@Test
	public void CheckDynamicText3() {
		String Text = dynContPageObj.DynamicText3.getText();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		String TextAfterRefresh = dynContPageObj.DynamicText3.getText();
		Assert.assertNotEquals(Text, TextAfterRefresh);

	}

	@Test
	public void CheckDynamicPicture1() throws InterruptedException {
		Thread.sleep(3000);
		String Text = dynContPageObj.DynamicPicture1.getAttribute("src");
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		String TextAfterRefresh = dynContPageObj.DynamicPicture1.getAttribute("src");
		Assert.assertNotEquals(Text, TextAfterRefresh);

	}

	@Test
	public void CheckDynamicPicture2() throws InterruptedException {
		String Text = dynContPageObj.DynamicPicture2.getAttribute("src");
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		String TextAfterRefresh = dynContPageObj.DynamicPicture2.getAttribute("src");
		Assert.assertNotEquals(Text, TextAfterRefresh);
	}

	@Test
	public void CheckDynamicPicture3() throws InterruptedException {
		String Text = dynContPageObj.DynamicPicture3.getAttribute("src");
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		String TextAfterRefresh = dynContPageObj.DynamicPicture3.getAttribute("src");
		Assert.assertNotEquals(Text, TextAfterRefresh);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
