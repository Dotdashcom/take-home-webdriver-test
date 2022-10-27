package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.Utils.Utils;
import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.TheInternetPage;
import com.takeHomeTest.pages.UploadPage;

public class UploadPageTest extends TestBase {

	UploadPage uploadPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void uploadTest() {
		uploadPage = theInternetPage.clickuploadPageBtn();
		uploadPage.uploadFile("C:\\Users\\skpos\\Downloads\\some-file.txt");
		Utils.sleep(2000);
		uploadPage.clickuploadBtn();
		Assert.assertEquals(uploadPage.getuploadConfirmationMsg(), "File Uploaded!", "Upload not successful");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
