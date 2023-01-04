package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.OpenNewTabPage;

public class OpenNewTabTest extends BaseTest {
    private OpenNewTabPage openNewTabPage;

    @BeforeMethod
    public void setup() {
        openNewTabPage = homePage.gotoOpenNewTabPage();
    }

    @Test
    public void verifyTextOnNewTab() {
        String newWindowHeaderText = openNewTabPage.clickHere()
                .getHeaderText();
        Assert.assertEquals(newWindowHeaderText, "New Window");
    }
}