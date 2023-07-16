package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ContextMenuPage;
import testComponents.BaseTest;

public class ContextMenuTest extends BaseTest {

    @Test
    public void performContextClick() throws InterruptedException {
        ContextMenuPage contextMenu=new ContextMenuPage(driver);
        contextMenu.goTo();
        contextMenu.rightclick();
        Thread.sleep(5000);
        System.out.println(contextMenu.textAlert());
        Assert.assertEquals(contextMenu.textAlert(),"You selected a context menu" );
        contextMenu.switchAlert();


    }
}
