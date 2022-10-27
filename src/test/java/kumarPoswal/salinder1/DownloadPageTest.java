package kumarPoswal.salinder1;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.Utils.Utils;
import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.DownloadPage;
import com.takeHomeTest.pages.TheInternetPage;

public class DownloadPageTest extends TestBase {

	DownloadPage downloadPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void downloadTest() {
		downloadPage = theInternetPage.clickDownloadPageBtn();
		downloadPage.clickdownloadBtn();
		Utils.sleep(2000);
		String home = System.getProperty("user.home");
		home = home + "/Downloads/";
		File folder = new File(home);
		File[] listOfFiles = folder.listFiles();
		boolean found = false;

		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				if (fileName.contains("some-file")) {

					found = true;
				}
			}
		}
		Assert.assertTrue(found, "File not downloaded");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
