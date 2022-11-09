import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;
import pages.HomePage;

public class FloatingMenuTest extends BaseTest {

    @Test
    public void floatingMenuActionTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

        boolean header = floatingMenuPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        String result = floatingMenuPage.floatingMenuTest();
        Assert.assertEquals(result, "Home", "validation is not successful");

    }

}
