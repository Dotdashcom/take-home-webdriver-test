package tests;

import model.StaticContentPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.BaseUtils;

public class StaticContentTest extends BaseTest {

    @Test
    public void testStaticContentFirstRowImageChange() {
        StaticContentPage staticContentPage = new StaticContentPage(getDriver())
                .getStaticContentPage();
        String imageSourceBeforeRefresh = staticContentPage.getFirstRowImageSource();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String imageSourceAfterRefresh = staticContentPage.getFirstRowImageSource();
        for(attemptsCounter = 1; imageSourceBeforeRefresh.equals(imageSourceAfterRefresh) && attemptsCounter <= attemptsToRefresh; attemptsCounter++) {
            getDriver().navigate().refresh();
            imageSourceAfterRefresh = staticContentPage.getFirstRowImageSource();
        }
        if(imageSourceBeforeRefresh.equals(imageSourceAfterRefresh)) {
            BaseUtils.log(String.format("\nRemains the same after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }

        Assert.assertEquals(imageSourceBeforeRefresh, imageSourceAfterRefresh);
    }

    @Test
    public void testStaticContentSecondRowImageChange() {
        StaticContentPage staticContentPage = new StaticContentPage(getDriver())
                .getStaticContentPage();
        String imageSourceBeforeRefresh = staticContentPage.getSecondRowImageSource();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String imageSourceAfterRefresh = staticContentPage.getSecondRowImageSource();
        for(attemptsCounter = 1; imageSourceBeforeRefresh.equals(imageSourceAfterRefresh) && attemptsCounter <= attemptsToRefresh; attemptsCounter++) {
            getDriver().navigate().refresh();
            imageSourceAfterRefresh = staticContentPage.getSecondRowImageSource();
        }
        if(imageSourceBeforeRefresh.equals(imageSourceAfterRefresh)) {
            BaseUtils.log(String.format("\nRemains the same after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }

        Assert.assertEquals(imageSourceBeforeRefresh, imageSourceAfterRefresh);
    }

    @Test
    public void testStaticContentThirdRowImageChange_testToFail() {
        StaticContentPage staticContentPage = new StaticContentPage(getDriver())
                .getStaticContentPage();
        String imageSourceBeforeRefresh = staticContentPage.getThirdRowImageSource();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String imageSourceAfterRefresh = staticContentPage.getThirdRowImageSource();
        for(attemptsCounter = 1; imageSourceBeforeRefresh.equals(imageSourceAfterRefresh) && attemptsCounter <= attemptsToRefresh; attemptsCounter++) {
            getDriver().navigate().refresh();
            imageSourceAfterRefresh = staticContentPage.getThirdRowImageSource();
        }
        if(imageSourceBeforeRefresh.equals(imageSourceAfterRefresh)) {
            BaseUtils.log(String.format("\nRemains the same after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }

        Assert.assertTrue(imageSourceBeforeRefresh.equals(imageSourceAfterRefresh), "This test fails. Ask me at the interview");
    }

    @Test
    public void testStaticContentFirstRowTextChange() {
        StaticContentPage staticContentPage = new StaticContentPage(getDriver())
                .getStaticContentPage();
        String textBeforeRefresh = staticContentPage.getFirstRowText();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String textAfterRefresh = staticContentPage.getFirstRowText();
        for(attemptsCounter = 1; textBeforeRefresh.equals(textAfterRefresh) && attemptsCounter <= attemptsToRefresh; attemptsCounter++) {
            getDriver().navigate().refresh();
            textAfterRefresh = staticContentPage.getFirstRowText();
        }
        if(textBeforeRefresh.equals(textAfterRefresh)) {
            BaseUtils.log(String.format("\nRemains the same after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }

        Assert.assertEquals(textBeforeRefresh, textAfterRefresh);
    }

    @Test
    public void testStaticContentSecondRowTextChange() {
        StaticContentPage staticContentPage = new StaticContentPage(getDriver())
                .getStaticContentPage();
        String textBeforeRefresh = staticContentPage.getSecondRowText();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String textAfterRefresh = staticContentPage.getSecondRowText();
        for(attemptsCounter = 1; textBeforeRefresh.equals(textAfterRefresh) && attemptsCounter <= attemptsToRefresh; attemptsCounter++) {
            getDriver().navigate().refresh();
            textAfterRefresh = staticContentPage.getSecondRowText();
        }
        if(textBeforeRefresh.equals(textAfterRefresh)) {
            BaseUtils.log(String.format("\nRemains the same after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }

        Assert.assertEquals(textBeforeRefresh, textAfterRefresh);
    }
    
    @Test
    public void testStaticContentThirdRowTextChange_testToFail() {
        StaticContentPage staticContentPage = new StaticContentPage(getDriver())
                .getStaticContentPage();
        String textBeforeRefresh = staticContentPage.getThirdRowText();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String textAfterRefresh = staticContentPage.getThirdRowText();
        for(attemptsCounter = 1; textBeforeRefresh.equals(textAfterRefresh) && attemptsCounter <= attemptsToRefresh; attemptsCounter++) {
            getDriver().navigate().refresh();
            textAfterRefresh = staticContentPage.getThirdRowText();
        }
        if(textBeforeRefresh.equals(textAfterRefresh)) {
            BaseUtils.log(String.format("\nRemains the same after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }

        Assert.assertTrue(textBeforeRefresh.equals(textAfterRefresh), "This test fails. Ask me at the interview");
    }
}