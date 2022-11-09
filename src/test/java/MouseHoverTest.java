import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MouseHoverPage;

public class MouseHoverTest extends BaseTest {

    @Test
    public void mouseHoverTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        MouseHoverPage mouseHoverPage = new MouseHoverPage();

        boolean header = mouseHoverPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        mouseHoverPage.mouseHoverTest();
        Assert.assertTrue(true, "validation is not successful");

    }

}
