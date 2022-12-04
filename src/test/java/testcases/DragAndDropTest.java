package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DragAndDropPage;
import baseTest.AbstractE2E;

public class DragAndDropTest {

	WebDriver driver;
	DragAndDropPage dragAndDropPage;

	@Test(description = "Perform Drag and Drop")
	public void TC01_dragAndDropTest_success() throws Exception {
		dragAndDropPage.dragAndDrop();
		Boolean checkDragDrop = dragAndDropPage.verifyDragAndDrop();
		Assert.assertTrue(checkDragDrop);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		dragAndDropPage = new DragAndDropPage(driver);
		dragAndDropPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
