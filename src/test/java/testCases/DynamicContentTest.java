package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjectModel.DynamicContentPage;
import pageObjectModel.HomePage;

public class DynamicContentTest extends BaseTest {	
	@Test(invocationCount = 5)
	public void dynamicContent() {
	HomePage homePage = new HomePage(driver);
	DynamicContentPage dynamicContent = homePage.clickDynamicContent();
	String OriginalFirstContent = dynamicContent.getFirstContent();
	String OriginalSecondContent = dynamicContent.getSecondContent();
	String OriginalThirdContent = dynamicContent.getThirdContent();
	SoftAssert softAssert = new SoftAssert();
	for(int i=1; i<=3; i++) {
		dynamicContent.refreshPage();
	}
	softAssert.assertNotEquals(OriginalFirstContent, dynamicContent.getFirstContent());
	softAssert.assertNotEquals(OriginalSecondContent, dynamicContent.getSecondContent());
	softAssert.assertNotEquals(OriginalThirdContent,dynamicContent.getThirdContent());
	softAssert.assertAll();
	}
}
