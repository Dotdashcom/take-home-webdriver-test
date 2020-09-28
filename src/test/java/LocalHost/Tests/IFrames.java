package LocalHost.Tests;

import LocalHost.Pages.IFramesPage;
import LocalHost.Utilities.BrowserUtils;
import org.testng.annotations.Test;

public class IFrames extends TestingBase{

    @Test(groups = "Iframes")
    public void TestFrames(){
        IFramesPage page = new IFramesPage();
        page.switchingFrames();
        BrowserUtils.waitFor(3);
    }

}
