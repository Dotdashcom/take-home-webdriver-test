package tests;

import enums.Headers;
import enums.Pages;
import org.testng.annotations.Test;
import pages.DynamicContentPage;
import utilities.BrowserUtils;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicContentTest extends TestBase {

    @Test(description = "Dynamic Content Test")
    public void dynamicContentTest() throws InterruptedException {
        DynamicContentPage dynamicContentPage = new DynamicContentPage();
        BrowserUtils.openPage(driver, Pages.DYNAMIC_CONTENT_PAGE);
        BrowserUtils.waitUntilVisible(driver, dynamicContentPage.header, Duration.ofSeconds(15));
        assertThat(dynamicContentPage.header.getText()).isEqualTo(Headers.DYNAMIC_CONTENT.getName());
        for (int i = 0; i < dynamicContentPage.allimages.size(); i++) {
            List<String> imagesBeforeRefresh =
                    BrowserUtils.getAttributeValues(dynamicContentPage.allimages, "src");
            List<String> textsBeforeRefresh = BrowserUtils.getAllTexts(dynamicContentPage.allTextColumns);
            driver.navigate().refresh();
            List<String> imagesAfterRefresh =
                    BrowserUtils.getAttributeValues(dynamicContentPage.allimages,"src");
            List<String> textsAfterRefresh = BrowserUtils.getAllTexts(dynamicContentPage.allTextColumns);
            assertThat(imagesAfterRefresh).as("Images should not be equal.").isNotEqualTo(imagesBeforeRefresh);
            assertThat(textsAfterRefresh).as("Text should not be equal.").isNotEqualTo(textsBeforeRefresh);
        }
    }
}
