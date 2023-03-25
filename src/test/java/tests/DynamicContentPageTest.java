package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DynamicContentPage;

public class DynamicContentPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "dynamicContentUrl"})
    public void dynamic_Content_Test(String baseUrl, String dynamicContentUrl) {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.goToUrl(baseUrl , dynamicContentUrl);

        String firstImageSrc = dynamicContentPage.getFirstImageSrc();
        String secondImageSrc = dynamicContentPage.getSecondImageSrc();
        String thirdImageSrc = dynamicContentPage.getThirdImageSrc();
        String firstText = dynamicContentPage.getFirstText();
        String secondText = dynamicContentPage.getSecondText();
        String thirdText = dynamicContentPage.getThirdText();

        dynamicContentPage.refreshPage();

        String newFirstImageSrc = dynamicContentPage.getFirstImageSrc();
        String newSecondImageSrc = dynamicContentPage.getSecondImageSrc();
        String newThirdImageSrc = dynamicContentPage.getThirdImageSrc();
        String newFirstText = dynamicContentPage.getFirstText();
        String newSecondText = dynamicContentPage.getSecondText();
        String newThirdText = dynamicContentPage.getThirdText();

        Assert.assertFalse(firstImageSrc.equals(newFirstImageSrc));
        Assert.assertFalse(firstText.equals(newFirstText));
        Assert.assertFalse(secondImageSrc.equals(newSecondImageSrc));
        Assert.assertFalse(secondText.equals(newSecondText));
        Assert.assertFalse(thirdImageSrc.equals(newThirdImageSrc));
        Assert.assertFalse(thirdText.equals(newThirdText));

    }
}
