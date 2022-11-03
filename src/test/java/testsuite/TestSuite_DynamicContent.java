package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.DynamicContentPage;

public class TestSuite_DynamicContent extends BaseTestClass {

    @Test(description = "Dynamic Content")
    public void TC_DynamicContent_001_ValidateFunctionality_DynamicContent() {
        ActionHelper.openUrl(Constants.DYNAMIC_CONTENT_PAGE_URL);
        DynamicContentPage dynamicContentPage = DynamicContentPage.getInstance();
        String textBefore = dynamicContentPage.getTextOfContent();
        ActionHelper.refresh();
        String textAfter = dynamicContentPage.getTextOfContent();
        Assert.assertNotEquals(textBefore, textAfter, "Validate Text Change after Refresh");
        textBefore = dynamicContentPage.getTextOfContent();
        ActionHelper.refresh();
        textAfter = dynamicContentPage.getTextOfContent();
        Assert.assertNotEquals(textBefore, textAfter, "Validate Text Change after Refresh");
        textBefore = dynamicContentPage.getTextOfContent();
        ActionHelper.refresh();
        textAfter = dynamicContentPage.getTextOfContent();
        Assert.assertNotEquals(textBefore, textAfter, "Validate Text Change after Refresh");
    }


}
