package LocalHost.Tests;

import LocalHost.Pages.DynamicLoadingPage;
import org.testng.annotations.Test;

public class DynamicLoading extends TestingBase {

    @Test(groups = "Dynamic2")
    public void VerifyMessage(){
        DynamicLoadingPage page = new DynamicLoadingPage();
        page.ClickStart();
        page.VerifyMessage();
    }
}
