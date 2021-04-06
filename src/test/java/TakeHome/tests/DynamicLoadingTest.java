package TakeHome.tests;

import TakeHome.pages.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends TestBase {

    @Test(groups = "Dynamic2")
    public void VerifyMessage(){
        DynamicLoadingPage page = new DynamicLoadingPage();
        page.clickStart();
        Assert.assertEquals(page.getMessage(),"Hello World!", "Message text is not as expected");
    }
}
