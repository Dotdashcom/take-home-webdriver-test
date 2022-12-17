package Tests;

import Pages.BasePage;
import Pages.ContextMenuPage;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContextMenuVerification extends BasePage {
    ContextMenuPage contextMenuPage = new ContextMenuPage();

    @BeforeClass
    public void SetUp(){
        Driver.GetDriver().get("http://localhost:7080/context_menu");
    }
    @Test
    public void TC1ContextMenuVerification() throws IOException {
        contextMenuPage.ClickContextMenu();
        Assert.assertEquals(contextMenuPage.AlertMessage(), "You selected a context menu");
        contextMenuPage.AcceptAlert();
        HelpfulMethods.takeScreenShot("ContextMenuVerification");

    }

}
