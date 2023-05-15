package testCases;

import pageObjectModel.HomePage;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageObjectModel.DynamicLoadingPage;

public class DynamicLoadingTest extends BaseTest {
	@Test
	public void dynamicLoading() {
		HomePage homePage= new HomePage(driver);
		DynamicLoadingPage dynamicLoading = homePage.clickDynamicLoading();
		String textMessage = dynamicLoading.finishText();
		assertEquals("Hello World!", textMessage);		
	}
}
