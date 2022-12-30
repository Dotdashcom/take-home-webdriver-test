package com.qa.INTest.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.FileUploadPage;
import com.qa.INTest.TestBase.TestBase;

public class FIleUploadTest extends TestBase {

	FileUploadPage fup;

	public FIleUploadTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initilize();
		fup = new FileUploadPage();
		fup.clickOnFileUpload();
	}

	@Test
	public void vldFileUploadTest() throws IOException, InterruptedException, AWTException {

		fup.clickOnChooseFileBtn();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
