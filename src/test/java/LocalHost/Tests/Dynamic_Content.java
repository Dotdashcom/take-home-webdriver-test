package LocalHost.Tests;

import static LocalHost.Utilities.BrowserUtils.*;
import LocalHost.Pages.Dynamic_Content_Page;
import org.testng.annotations.Test;

public class Dynamic_Content extends TestingBase {

    @Test(groups={"Dynamic_Content"})
    public void TestDynamic(){
        Dynamic_Content_Page dynamic = new Dynamic_Content_Page();
        waitForPageToLoad(3);
        dynamic.VerifyMessage1();
        dynamic.VerifyMessage2();
        dynamic.VerifyMessage3();
        dynamic.VerifyStatic();

    }
}
