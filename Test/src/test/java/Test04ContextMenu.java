
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObject.ContextMenuPage;

public class Test04ContextMenu extends TestBase{


    @Test
    public void test04ContextMenu(){
        ContextMenuPage contextMenuPage = new ContextMenuPage(webDriver);
        contextMenuPage.rightClickOnContextMenu();
        Assert.assertEquals(contextMenuPage.getAlertMessage(), "You selected a context menu");
    }

}