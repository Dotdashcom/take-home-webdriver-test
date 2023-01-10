package tests;

import model.DynamicContentPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.BaseUtils;

public class DynamicContentTest extends BaseTest {

    @Test
    public void testDynamicContentFirstRowImageChange() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(getDriver())
                .getDynamicContentPage();
        String imageSourceBeforeRefresh = dynamicContentPage.getFirstRowImageSource();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String imageSourceAfterRefresh = dynamicContentPage.getFirstRowImageSource();
        for(attemptsCounter = 1;
            imageSourceBeforeRefresh.equals(imageSourceAfterRefresh) && attemptsCounter <= attemptsToRefresh;
            attemptsCounter++) {
            getDriver().navigate().refresh();
            imageSourceAfterRefresh = dynamicContentPage.getFirstRowImageSource();
        }
        if(imageSourceBeforeRefresh.equals(imageSourceAfterRefresh)) {
            BaseUtils.log(String.format("\nFails to change after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }
        Assert.assertNotEquals(imageSourceBeforeRefresh, imageSourceAfterRefresh);
    }

    @Test
    public void testDynamicContentSecondRowImageChange() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(getDriver())
                .getDynamicContentPage();
        String imageSourceBeforeRefresh = dynamicContentPage.getSecondRowImageSource();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String imageSourceAfterRefresh = dynamicContentPage.getSecondRowImageSource();
        for(attemptsCounter = 1;
            imageSourceBeforeRefresh.equals(imageSourceAfterRefresh) && attemptsCounter <= attemptsToRefresh;
            attemptsCounter++) {
            getDriver().navigate().refresh();
            imageSourceAfterRefresh = dynamicContentPage.getSecondRowImageSource();
        }
        if(imageSourceBeforeRefresh.equals(imageSourceAfterRefresh)) {
            BaseUtils.log(String.format("\nFails to change after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }
        Assert.assertNotEquals(imageSourceBeforeRefresh, imageSourceAfterRefresh);
    }

    @Test
    public void testDynamicContentThirdRowImageChange() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(getDriver())
                .getDynamicContentPage();
        String imageSourceBeforeRefresh = dynamicContentPage.getThirdRowImageSource();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String imageSourceAfterRefresh = dynamicContentPage.getThirdRowImageSource();
        for(attemptsCounter = 1;
            imageSourceBeforeRefresh.equals(imageSourceAfterRefresh) && attemptsCounter <= attemptsToRefresh;
            attemptsCounter++) {
            getDriver().navigate().refresh();
            imageSourceAfterRefresh = dynamicContentPage.getThirdRowImageSource();
        }
        if(imageSourceBeforeRefresh.equals(imageSourceAfterRefresh)) {
            BaseUtils.log(String.format("\nFails to change after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }
        Assert.assertNotEquals(imageSourceBeforeRefresh, imageSourceAfterRefresh);
    }

    @Test
    public void testDynamicContentFirstRowTextChange() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(getDriver())
                .getDynamicContentPage();
        String textBeforeRefresh = dynamicContentPage.getFirstRowText();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String textAfterRefresh = dynamicContentPage.getFirstRowText();
        for(attemptsCounter = 1;
            textBeforeRefresh.equals(textAfterRefresh) && attemptsCounter <= attemptsToRefresh;
            attemptsCounter++) {
            getDriver().navigate().refresh();
            textAfterRefresh = dynamicContentPage.getFirstRowText();
        }
        if(textBeforeRefresh.equals(textAfterRefresh)) {
            BaseUtils.log(String.format("\nFails to change after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }
        Assert.assertNotEquals(textBeforeRefresh, textAfterRefresh);
    }

    @Test
    public void testDynamicContentSecondRowTextChange() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(getDriver())
                .getDynamicContentPage();
        String textBeforeRefresh = dynamicContentPage.getSecondRowText();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String textAfterRefresh = dynamicContentPage.getSecondRowText();
        for(attemptsCounter = 1;
            textBeforeRefresh.equals(textAfterRefresh) && attemptsCounter <= attemptsToRefresh;
            attemptsCounter++) {
            getDriver().navigate().refresh();
            textAfterRefresh = dynamicContentPage.getSecondRowText();
        }
        if(textBeforeRefresh.equals(textAfterRefresh)) {
            BaseUtils.log(String.format("\nFails to change after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }
        Assert.assertNotEquals(textBeforeRefresh, textAfterRefresh);
    }
    @Test
    public void testDynamicContentThirdRowTextChange() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(getDriver())
                .getDynamicContentPage();
        String textBeforeRefresh = dynamicContentPage.getThirdRowText();
        int attemptsToRefresh = 10;
        int attemptsCounter;

        getDriver().navigate().refresh();
        String textAfterRefresh = dynamicContentPage.getThirdRowText();
        for(attemptsCounter = 1;
            textBeforeRefresh.equals(textAfterRefresh) && attemptsCounter <= attemptsToRefresh;
            attemptsCounter++) {
            getDriver().navigate().refresh();
            textAfterRefresh = dynamicContentPage.getThirdRowText();
        }
        if(textBeforeRefresh.equals(textAfterRefresh)) {
            BaseUtils.log(String.format("\nFails to change after %d refreshes", attemptsToRefresh));
        } else {
            BaseUtils.log(String.format("\nElement changed after %d refreshes", attemptsCounter));
        }
        Assert.assertNotEquals(textBeforeRefresh, textAfterRefresh);
    }
}