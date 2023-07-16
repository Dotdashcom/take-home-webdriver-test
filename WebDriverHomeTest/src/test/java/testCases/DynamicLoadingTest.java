package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.DynamicLoadingPage;
import testComponents.BaseTest;

public class DynamicLoadingTest extends BaseTest {


    @Test
    public void dynamicloading(){
        DynamicLoadingPage dynamicLoadingPage=new DynamicLoadingPage(driver);
        dynamicLoadingPage.goTo();
        dynamicLoadingPage.clickSatrtButton();
        String message=dynamicLoadingPage.getText();
        Assert.assertEquals(message,"Hello World!");


    }





}
