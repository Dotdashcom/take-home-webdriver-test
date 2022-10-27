package kumarPoswal.salinder1;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.Utils.Utils;
import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.DynamicLoadingPage;
import com.takeHomeTest.pages.NotificationMsgPage;
import com.takeHomeTest.pages.TheInternetPage;

public class NotificationMsgTest extends TestBase {

	NotificationMsgPage notificationMsgPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void notificationMsgTest() {
		notificationMsgPage = theInternetPage.clickNotiifcationPage();
		Random random = new Random();
		int n = random.nextInt(7);              // clicking random time to shuffle the message displayed
		for (int i = 0; i <= n; i++) {
			notificationMsgPage.clickBtn();
		}

		Assert.assertEquals(notificationMsgPage.msgContaines(notificationMsgPage.getMsg()), true);

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
