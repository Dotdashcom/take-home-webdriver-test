package LocalHost.Tests;

import LocalHost.Pages.ContextPage;
import static LocalHost.Utilities.BrowserUtils.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu extends TestingBase{

    @Test(groups = {"ContextMenu"})
    public void Testing_Alert(){
        ContextPage contextPage = new ContextPage();
        waitForPageToLoad(5);
        contextPage.Context_Click();
        contextPage.VerifyAlertText();
        contextPage.Accept_Message();
        Assert.assertFalse(contextPage.AlertConfirmation());
    }
}
