package com.dotDash.test;

import com.dotDash.base.BaseTest;
import com.dotDash.page.DynamicLoadingPage;
import com.dotDash.page.FileDownloadPage;
import com.dotDash.page.common.PageinstancesFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileDownloadFeature_Test extends BaseTest{
	FileDownloadPage fileDownloadPage;
	@Test(description = "Test to Validate File Download Feature")
	void validateFileDownloadPage() throws InterruptedException, IOException {
		fileDownloadPage=PageinstancesFactory.getInstance(FileDownloadPage.class);
		fileDownloadPage.navigateToFileDowloadPage();
		fileDownloadPage.validateDynamicLoadingFeature();
	}
}