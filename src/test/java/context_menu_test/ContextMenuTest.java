package context_menu_test;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object_model.context_menu_page.ContextMenuPage;

public class ContextMenuTest extends Base {

    @Test
    public void rightClickTest(){
        ContextMenuPage contextMenuPage = new ContextMenuPage();
        contextMenuPage.rightClick();
        String alertText= driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(alertText,expectedText);
    }
    @Test
    public void rightClickUsingJsTest(){
        ContextMenuPage contextMenuPage = new ContextMenuPage();
        contextMenuPage.rightClickWithJavascriptExecutor();
        String alertText= driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(alertText,expectedText);
    }
}
