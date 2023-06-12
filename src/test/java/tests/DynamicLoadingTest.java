package tests;

import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class DynamicLoadingTest extends BaseTest{
    @Test
    public void dynamicLoading() {
        HomePage homePage= new HomePage(driver);
        DynamicLoadingPage dynamicLoading = homePage.clickDynamicLoading();
        String textMessage = dynamicLoading.getFinishText();
        assertEquals("Hello World!", textMessage);
    }
}
