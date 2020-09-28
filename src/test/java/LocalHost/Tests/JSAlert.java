package LocalHost.Tests;

import LocalHost.Pages.JSAlertPage;
import LocalHost.Utilities.BrowserUtils;
import org.testng.annotations.Test;

public class JSAlert extends TestingBase{
    JSAlertPage page;

    @Test(groups = "JSAlert")
    public void TestAlert(){
        page= new JSAlertPage();
        BrowserUtils.waitFor(3);
        page.jsAlert();
    }

    @Test(groups = "JSAlert")
    public void AcceptAlert(){
        page=new JSAlertPage();
        BrowserUtils.waitFor(3);
        page.acceptAlert();
    }

    @Test(groups = "JSAlert")
    public void TypeJSAlert(){
        page=new JSAlertPage();
        page.SendMessage();


    }
}
