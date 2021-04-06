package TakeHome.tests;

import TakeHome.pages.DynamicContentPage;
import TakeHome.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContentTest extends TestBase {

    @Test(groups={"Dynamic_Content"})

    public void TestDynamic(){

        DynamicContentPage dynamic = new DynamicContentPage();
        BrowserUtils.waitForPageToLoad(3);
        Assert.assertTrue(dynamic.verifyMessage1Changes());
        Assert.assertTrue(dynamic.verifyMessage2Changes());
        Assert.assertTrue(dynamic.verifyMessage3Changes());
        Assert.assertTrue(dynamic.verifyTopTwoMessagesRemainAfterStaticClick());

    }
}

