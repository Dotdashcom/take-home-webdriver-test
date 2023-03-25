package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.OpenInNewTabPage;

public class OpenInNewTabPageTest extends TestConfiguration {
    @Test
    @Parameters({"baseUrl", "openInNewTabUrl", "newWindowTitle"})
    public void open_In_New_Tab_Test(String baseUrl, String openInNewTabUrl, String newWindowTitle) {
        OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage(driver);
        openInNewTabPage.goToUrl(baseUrl , openInNewTabUrl);

        openInNewTabPage.clickLink();
        openInNewTabPage.switchToNewWindow();
        Assert.assertTrue(openInNewTabPage.getNewWindowText().equals(newWindowTitle));
    }
}
