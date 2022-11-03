package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MultipleWindowsPage;

public class TestSuite_Windows extends BaseTestClass {

    @Test
    public void TC_Windows_001_Verify_HeaderOnNewWindow() {
        ActionHelper.openUrl(Constants.WINDOW_PAGE_URL);
        MultipleWindowsPage multipleWindowsPage = MultipleWindowsPage.getInstance();
        multipleWindowsPage.clickLink();
        ActionHelper.switchToNewWindow();
        Assert.assertEquals(multipleWindowsPage.getTextHeader(), "New Window");
        ActionHelper.switchToParentWindow();
    }
}
