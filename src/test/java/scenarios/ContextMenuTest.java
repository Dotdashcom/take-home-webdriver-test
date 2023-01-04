package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ContextMenuPage;


public class ContextMenuTest extends BaseTest {
    private ContextMenuPage contextMenuPage;

    @BeforeMethod
    public void setup() {
        contextMenuPage = homePage.gotoContextMenuPage();
    }

    @Test
    public void testJavascriptRightClick() {
        String javaScriptAlertText = contextMenuPage.rightClickContextMenuBox()
                .getJavaScriptAlertText();

        Assert.assertEquals(javaScriptAlertText, "You selected a context menu");
    }
}