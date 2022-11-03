package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FloatingMenuPage;

public class TestSuite_FloatingMenu extends BaseTestClass {

    @Test
    public void TC_001_FloatingMenu_floatingMenuDisplayedScrollTest() {
        ActionHelper.openUrl(Constants.FLOATING_PAGE_URL);
        FloatingMenuPage floatingMenuPage = FloatingMenuPage.getInstance();
        floatingMenuPage.scrollToBottom();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());
    }
}
