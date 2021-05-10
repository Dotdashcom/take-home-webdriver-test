package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.DragAndDropPage;
import com.dotdash.util.DriverUtil;

public class TestDragAndDrop extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test drag box 1 to box 2, then texts on the boxes are switched")
	private void testDragAndDrop() {
		DragAndDropPage dragAndDropPage = navigateTo(driver, DragAndDropPage.class);
		dragAndDropPage.verifyPage();
		
		dragAndDropPage.dragFirstBoxToSecondBox();
		dragAndDropPage.verifyPage(new char[] {'B', 'A'});
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
