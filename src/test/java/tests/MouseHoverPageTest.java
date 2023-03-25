package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MouseHoverPage;

import java.util.List;

public class MouseHoverPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "mouseHoverUrl"})
    public void mouse_Hover_Test(String baseUrl, String mouseHoverUrl) {
        MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);
        mouseHoverPage.goToUrl(baseUrl , mouseHoverUrl);

        List<WebElement> images = mouseHoverPage.getImages();
        List<WebElement> infos = mouseHoverPage.getInfo();
        for(int i=0; i<images.size();i++){
            mouseHoverPage.mouseHover(images.get(i));
            Assert.assertTrue(mouseHoverPage.isInfoDisplayed(infos.get(i)));
        }
    }
}
