package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.DynamicContentPage;

public class DynamicContentPageTests extends BaseTest {
    DynamicContentPage dynamicContentPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        dynamicContentPage = homePage.navigateToDynamicContextPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(dynamicContentPage.dynamicContextPageLanding(),
                "Dynamic context page not loaded");
    }

    @Test(priority = 1)
    public void testDynamicContextText() throws InterruptedException {
        String textBox = "1";
        String dynamicText = dynamicContentPage.getDynamicContentText(textBox);
        driver.navigate().refresh();
        Thread.sleep(2000);
        String newDynamicText = dynamicContentPage.getDynamicContentText(textBox);
        Assert.assertNotEquals(dynamicText, newDynamicText, "Dynamic text is the same");
    }

    @Test(priority = 2)
    public void testDynamicContextPicture() throws InterruptedException {
        String pictureBox = "2";
        String dynamicPicture = dynamicContentPage.getDynamicContentPicture(pictureBox);
        driver.navigate().refresh();
        Thread.sleep(2000);
        String newDynamicPicture = dynamicContentPage.getDynamicContentPicture(pictureBox);
        Assert.assertNotEquals(dynamicPicture, newDynamicPicture, "Dynamic text is the same");
    }
}
