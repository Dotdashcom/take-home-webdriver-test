import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import pages.HomePage;

public class ContextMenuTest extends BaseTest {

    @Test
    public void ContextMenuAlertTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        ContextMenuPage contextMenuPage = new ContextMenuPage();
        boolean header = contextMenuPage.navigatetoContextmenupage().contextMenuHeader();

        Assert.assertTrue(header, "page is not navigated");
        String AlertText = ContextMenuPage.VerifyContextMenu();

        Assert.assertEquals(AlertText, "You selected a context menu", "validation is not successful");

    }

}
