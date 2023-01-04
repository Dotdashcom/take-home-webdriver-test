package scenarios;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DynamicContentPage;


public class DynamicContentTest extends BaseTest {
    private DynamicContentPage dynamicContentPage;

    @BeforeMethod
    public void setup() {
        dynamicContentPage = homePage.gotoDynamicContentPage();
    }

    @Test
    public void verifyContentChangesOnReload() {
        String content = dynamicContentPage.getContentText();
        SoftAssert softAssert = new SoftAssert();

        for(int i = 0; i < 10; i++) {
            dynamicContentPage.refresh();
            softAssert.assertNotEquals(content, content = dynamicContentPage.getContentText(), "Page content should change!");
        }

        softAssert.assertAll();
    }
}