import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import pages.HomePage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void DragAndDropActionTest() throws InterruptedException {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        DragAndDropPage dragAndDropPage = new DragAndDropPage();

        boolean header = dragAndDropPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        boolean result = dragAndDropPage.VerifyDragAndDrop();
        Assert.assertTrue(result, "validation is not successful");

    }

}
