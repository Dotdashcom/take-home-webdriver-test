
import org.testng.annotations.Test;

import org.testng.Assert;
import pageObject.DynamicLoadingPage;

public class Test09DynamicLoading extends TestBase{
    
    @Test
    public void test09DynamicLoading(){
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(webDriver);
        dynamicLoadingPage.startLoading();
        Assert.assertTrue(dynamicLoadingPage.isloaded());
    }
}
