package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.DynamicContentPage;

public class DynamicContentTest extends GenericPage {
	DynamicContentPage dynaContentPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/dynamic_content");
		dynaContentPage = new DynamicContentPage();
	}

	@Test
	public void tcDynamicText() throws InterruptedException{
		String beforeText = dynaContentPage.text1.getText();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		String afterText = dynaContentPage.text1.getText();
		Assert.assertNotEquals(beforeText, afterText);
		
		beforeText = dynaContentPage.text2.getText();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		afterText = dynaContentPage.text2.getText();
		Assert.assertNotEquals(beforeText, afterText);
		
	}
}