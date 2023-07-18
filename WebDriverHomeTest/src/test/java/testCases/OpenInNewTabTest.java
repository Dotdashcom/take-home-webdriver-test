package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.OpenInNewTabPage;
import testComponents.BaseTest;

public class OpenInNewTabTest extends BaseTest {

    @Test
    public void newTab(){
        OpenInNewTabPage openInNewTabPage=new OpenInNewTabPage(driver);
        openInNewTabPage.goTO();
        openInNewTabPage.clickTheLink();
        String message=openInNewTabPage.getMessage();
        Assert.assertEquals(message,"New Window");
    }
}
