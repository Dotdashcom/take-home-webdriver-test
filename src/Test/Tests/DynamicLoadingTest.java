package Tests;

import Pages.BasePage;
import Pages.DynamicLoadingPage;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BasePage {
    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    @BeforeClass
    public void SetUp() {
        Driver.GetDriver().get("http://localhost:7080/dynamic_loading");
    }
    @Test
    public void TCDynamicLoadingVerification(){
        dynamicLoadingPage.DynamicElementClickingElement1();
        HelpfulMethods.staticWait(5);
        Assert.assertEquals(dynamicLoadingPage.SuccessMessage(),"Hello World!");
        Driver.GetDriver().navigate().back();
        dynamicLoadingPage.DynamicElementClickingElement2();
        HelpfulMethods.staticWait(5);
        Assert.assertEquals(dynamicLoadingPage.SuccessMessage(),"Hello World!");
    }

}
