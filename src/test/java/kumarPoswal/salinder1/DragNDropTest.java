package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.DragNDropPage;
import com.takeHomeTest.pages.TheInternetPage;

public class DragNDropTest extends TestBase {

	DragNDropPage dragNDrop;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void DragAndDropTest(){
		dragNDrop = theInternetPage.clickDragNDropBtn();
		dragNDrop.dragNdrop();
		Assert.assertEquals(dragNDrop.isTextExchanged(), true);
		

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
