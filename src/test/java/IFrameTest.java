import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.iFramePage;

public class IFrameTest extends BaseTest {

    @Test
    public void iFrameTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        iFramePage iFramePage = new iFramePage();

        boolean header = iFramePage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        String result = iFramePage.frameTest();
        Assert.assertEquals(result, "Your content goes here.Type into Iframe", "validation is not successful");

    }

}
