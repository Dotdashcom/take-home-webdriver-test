package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.IframPage;
import testComponents.BaseTest;

public class IframTest extends BaseTest {


    @Test
    public void ifram(){
        IframPage iframPage=new IframPage(driver);
        iframPage.goTo();
        iframPage.closeAlert();
        iframPage.cleartextBox();
        String text=iframPage.sendText();
        Assert.assertEquals(text,"I have 6 years experience in automation");

    }
}
