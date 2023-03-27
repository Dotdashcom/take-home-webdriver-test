package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.FileDownloadPage;
import com.dotDash.page.FileUploadPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileUploadFeature_Test extends BaseTest{
	FileUploadPage fileUploadPage;
	@Test(description = "Test to Validate Upload Feature")
	void validateFileUploadPage() throws InterruptedException, IOException {
		fileUploadPage=PageinstancesFactory.getInstance(FileUploadPage.class);
		fileUploadPage.navigateToFileUploadPage();
		fileUploadPage.validateFileUploadFeature();
	}
}